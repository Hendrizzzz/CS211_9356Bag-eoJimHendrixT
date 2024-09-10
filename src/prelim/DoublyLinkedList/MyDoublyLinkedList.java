package prelim.DoublyLinkedList;

import prelim.DoublyLinkedNode;
import prelim.MyLinkedList;

import java.util.NoSuchElementException;


/**
 * A custom implementation of a doubly linked list.
 *
 * @param <T> the type of elements stored in the list
 */
public class MyDoublyLinkedList<T> implements MyLinkedList<T> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;
    private int size;


    /**
     * Constructs an empty doubly linked list.
     */
    public MyDoublyLinkedList() {
        this.size = 0;
    }


    /**
     * Constructs a doubly linked list with an initial element.
     *
     * @param data the initial element to insert
     */
    public MyDoublyLinkedList(T data) {
        this.head = new DoublyLinkedNode<>(data);
        this.head.setPrevious(null); // The first element in a doubly-LinkedList is none
        this.size = 1;
    }


    /**
     * Returns the data of the head node.
     *
     * @return the data of the head node, or null if the list is empty
     */
    @Override
    public T getHead() {
        return head == null ? null : head.getData();
    }

    /**
     * Returns the data of the tail node.
     *
     * @return the data of the tail node, or null if the list is empty
     */
    @Override
    public T getTail() {
        return tail == null ? null : head.getData();
    }

    /**
     * Returns the head node of the list (package-private).
     * Hidden in the package so that only 2 class can access (tester classes)
     * @return the head node
     */
    DoublyLinkedNode<T> getHeadNode() {
        return head;
    }


    /**
     * Returns the tail node of the list (package-private).
     * Hidden in the package so that only 2 class can access (tester classes)
     *
     * @return the tail node
     */
    DoublyLinkedNode<T> getTailNode() {
        return tail;
    }


    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     */
    @Override
    public int getSize() {
        return this.size;
    }


    /**
     * Inserts a new element into the list.
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
        else
            head.setNext(insertRecursion(data, this.head.getNext(), this.head));

        size++;
    }

    private DoublyLinkedNode<T> insertRecursion(T data, DoublyLinkedNode<T> current, DoublyLinkedNode<T> prev) {
        if (current == null){
            DoublyLinkedNode<T> nodeToInsert = new DoublyLinkedNode<>(prev, data, null);
            this.tail = nodeToInsert;
            return nodeToInsert;
        }

        current.setNext(insertRecursion(data, current.getNext(), current));
        return current;
    }


    /**
     * Retrieves an element by value.
     *
     * @param data the value to search for
     * @return the element, or throws NoSuchElementException if not found
     * @throws NoSuchElementException if the element is not found
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
     * Deletes an element by value.
     *
     * @param data the value to delete
     * @return true if the element was deleted, false otherwise
     */
    @Override
    public boolean delete(T data) {
        if (this.head == null) // return immediately if the list has no elements
            return false;

        boolean isDeleted = true;

        if (this.head == this.tail && this.head.getData().equals(data)){
            this.head = null;
            this.tail = null;
        }
        // Add a shortcut if the data to be deleted is from one of the ends
        else if (this.head.getData().equals(data)) {// If from the head
            this.head = head.getNext();
            this.head.setPrevious(null);
        }
        else if (this.tail.getData().equals(data)) {  // If from the tail
            this.tail = tail.getPrevious();
            this.tail.setNext(null);
        }
        else
            isDeleted = deleteRecursion(data, this.head);

        if (isDeleted) --this.size;
        return isDeleted;
    }

    private boolean deleteRecursion(T data, DoublyLinkedNode<T> current) {
        if (current.getNext() == null) // The list does not contain the data to be deleted
            return false;

        else if (current.getNext().getData().equals(data)){ // If equal then:
            current.setNext(current.getNext().getNext());
            if (current.getNext() != null) // Set the previous of the next element to the current if the next node is not null
                current.getNext().setPrevious(current); // Set the previous of the new next node to the current node
            else  // If the current node's next node is null, then the current node should be the tail
                this.tail = current;
            return true;
        }

        else
            return deleteRecursion(data, current.getNext()); // Count the newSize as we traverse into the nodes
    }


    /**
     * Searches for an element by value and returns its index.
     *
     * @param data the value to search for
     * @return the index of the element, or -1 if not found
     */
    @Override
    public int search(T data) {
        int index = 0;
        return searchRecursion(data, this.head, index);
    }

    // If the list is 3rd in the list, it will return its index, which is 2
    private int searchRecursion(T data, DoublyLinkedNode<T> node, int index) {
        if (node == null) // The Whole list is already searched, and the element to search is not present in the list
            return -1;

        else if (node.getData().equals(data))
            return index;

        else
            return searchRecursion(data, node.getNext(), ++index);
    }


    /**
     * Retrieves an element by index.
     *
     * @param index the index to retrieve
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