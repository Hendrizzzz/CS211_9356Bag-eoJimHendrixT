package prelim.CircularLinkedList;

import prelim.DoublyLinkedNode;
import prelim.MyLinkedList;

import java.util.NoSuchElementException;

/**
 * A circular doubly linked list implementation.
 *
 * @param <T> the type of elements in this list
 */
public class MyDoublyLinkedCircularList<T> implements MyLinkedList<T> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;
    private int size;


    /**
     * Constructs an empty circular doubly linked list.
     */
    public MyDoublyLinkedCircularList() {
        this.head = null;
        this.size = 0;
    }


    /**
     * Constructs a circular doubly linked list with an initial element.
     *
     * @param data the initial element
     */
    public MyDoublyLinkedCircularList(T data) {
        this.head = new DoublyLinkedNode<>(data);
        this.head.setPrevious(null); // The first element in a doubly-LinkedList is none
        this.size = 1;
    }


    /**
     * Returns the data stored in the head node.
     *
     * @return the data at the head, or null if the list is empty
     */
    @Override
    public T getHead() {
        return head == null ? null : head.getData();
    }

    /**
     * Returns the data stored in the tail node.
     *
     * @return the data at the tail, or null if the list is empty
     */
    @Override
    public T getTail() {
        return tail == null ? null : tail.getData();
    }

    /**
     * Returns the head node.
     * Hidden in the package so that only two class can access (tester classes)
     *
     * @return the head node, or null if the list is empty
     */
    DoublyLinkedNode<T> getHeadNode() {
        return head;
    }

    /**
     * Returns the tail node.
     * Hidden in the package so that only two class can access (tester classes)
     *
     * @return the tail node, or null if the list is empty
     */
    DoublyLinkedNode<T> getTailNode() {
        return tail;
    }


    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    @Override
    public int getSize() {
        return this.size;
    }



    /**
     * Inserts an element at the end of the list.
     *
     * @param data the element to insert
     */
    @Override
    public void insert(T data) {
        if (this.head == null) {
            DoublyLinkedNode<T> nodeToInsert = new DoublyLinkedNode<>(null, data, null);
            this.head = nodeToInsert;
            this.tail = nodeToInsert;
        }
        else {
            tail.setNext(null); // To prevent recurring infinitely
            head.setNext(insertRecursion(data, this.head.getNext(), this.head));
        }

        size++;
    }

    private DoublyLinkedNode<T> insertRecursion(T data, DoublyLinkedNode<T> current, DoublyLinkedNode<T> prev) {
        if (current == null){
            this.tail = new DoublyLinkedNode<>(prev, data, this.head);
            this.head.setPrevious(tail);
            return this.tail;
        }

        current.setNext(insertRecursion(data, current.getNext(), current));
        return current;
    }


    /**
     * Retrieves an element from the list.
     *
     * @param data the element to retrieve
     * @return the element, or null if not found
     * @throws NoSuchElementException if the element is not in the list
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        if (this.head.getData().equals(data)) {
            return this.head.getData();
        }
        return getElementRecursion(data, this.head.getNext());
    }

    private T getElementRecursion(T data, DoublyLinkedNode<T> node) {
        if (node.equals(this.head)) // Means it already traversed the list and returned back to the head
            return null;

        else if (node.getData().equals(data))
            return node.getData();

        else
            return getElementRecursion(data, node.getNext());
    }


    /**
     * Deletes an element from the list.
     *
     * @param data the element to delete
     * @return true if the element was deleted, false if not found
     */
    @Override
    public boolean delete(T data) {
        if (this.head == null) // return immediately if the list has no elements
            return false;

        boolean isDeleted = true;

        if (this.head == this.tail && this.head.getData().equals(data)){ // if size == 1
            this.head = null;
            this.tail = null;
        }
        // Add a shortcut if the data to be deleted is from one of the ends
        else if (this.head.getData().equals(data)) {// If from the head
            this.head = head.getNext();
            this.head.setPrevious(this.tail);
            this.tail.setNext(this.head);
        }
        else if (this.tail.getData().equals(data)) {  // If from the tail
            this.tail = tail.getPrevious();
            this.tail.setNext(this.head);
            this.head.setPrevious(this.tail);
        }
        else
            isDeleted = deleteRecursion(data, this.head);

        if (isDeleted) --this.size;
        return isDeleted;
    }

    private boolean deleteRecursion(T data, DoublyLinkedNode<T> current) {
        if (current.getNext().equals(this.head)) // The list does not contain the data to be deleted
            return false;

        else if (current.getNext().getData().equals(data)){ // If equal then:
            current.setNext(current.getNext().getNext());
            current.getNext().setPrevious(current); // Set the previous of the new next node to the current node
            return true;
        }

        else
            return deleteRecursion(data, current.getNext()); // Count the newSize as we traverse into the nodes
    }


    /**
     * Searches for the index of an element in the list.
     *
     * @param data the element to search for
     * @return the index of the element, or -1 if not found
     */
    @Override
    public int search(T data) {
        if (this.head.getData().equals(data))
            return 0;
        return searchRecursion(data, this.head.getNext(), 1);
    }

    // If the list is 3rd in the list, it will return its index, which is 2
    private int searchRecursion(T data, DoublyLinkedNode<T> node, int index) {
        if (node.equals(this.head)) // The Whole list is already searched, and the element to search is not present in the list
            return -1;

        else if (node.getData().equals(data))
            return index;

        else
            return searchRecursion(data, node.getNext(), ++index);
    }


    /**
     * Retrieves an element by its index in the list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || (index != 0 && index >= size))
            throw new IndexOutOfBoundsException();

        // Check what end is closest to the index, head or tail? then start the search on that end
        if (index < this.size - index)
            return getRecursion(index, this.head, 0);
        else
            return getRecursionReversed(index, this.tail, this.size - 1);
    }

    private T getRecursion(int indexToReturn, DoublyLinkedNode<T> node, int currentIndex) {
        if (currentIndex == indexToReturn)
            return node.getData();

        return getRecursion(indexToReturn, node.getNext(), ++currentIndex);
    }

    private T getRecursionReversed(int indexToReturn, DoublyLinkedNode<T> node, int currentIndex) {
        if (currentIndex == indexToReturn)
            return node.getData();

        return getRecursionReversed(indexToReturn, node.getPrevious(), --currentIndex);
    }

} // end of the class