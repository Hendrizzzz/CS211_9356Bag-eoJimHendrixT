package prelim.LinkedList;

import prelim.MyList;

import java.util.NoSuchElementException;

/**
 * A singly linked list implementation.
 *
 * @param <T> the type of elements held in this list
 */
public class MySinglyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    /**
     * Creates an empty list.
     */
    public MySinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Creates a list with a single element.
     *
     * @param data the initial element
     */
    public MySinglyLinkedList(T data) {
        // Set the first element both head and tail
        this.head = new Node<>(data);
        this.tail = new Node<>(data);
        this.size = 1;
    }


    /**
     * Returns the head node.
     *
     * @return the head node
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns the tail node.
     *
     * @return the tail node
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     */
    @Override
    public int getSize() {
        return size;
    }


    /**
     * Inserts a new element at the end of the list.
     *
     * @param data the element to insert
     */
    @Override
    public void insert(T data) {
        if (this.head == null)
            this.head = new Node<>(data, null);

        else
            insertRecursion(data, head);

        size++;
    }

    private void insertRecursion(T data, Node<T> node) {
        if (node.getNext() == null){
            node.setNext(new Node<>(data, null));
            this.tail = node.getNext();
            return;
        }

        insertRecursion(data, node.getNext());
    }


    /**
     * Returns the element if found.
     *
     * @param data the element to find
     * @return the element
     * @throws NoSuchElementException if the element is not found
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        return getElementRecursion(data, this.head);
    }

    private T getElementRecursion(T data, Node<T> node) {
        if (node == null)
            throw new NoSuchElementException("Element " + data + " is not in the list. ");

        else if (node.getData().equals(data))
            return node.getData();

        else
            return getElementRecursion(data, node.getNext());
    }


    /**
     * Deletes the first occurrence of the element.
     *
     * @param data the element to delete
     * @return true if the element was found and deleted, false otherwise
     */
    @Override
    public boolean delete(T data) {
        if (this.head == null){
            return false;
        }

        if (this.head.getData().equals(data)){
            this.head = this.head.getNext();
            this.size--;
            return true;
        }

        else
            return deleteRecursion(data, this.head);
    }

    private boolean deleteRecursion(T data, Node<T> node) {
        if (node.getNext() == null)
            return false;

        else if (node.getNext().getData().equals(data)){
            node.setNext(node.getNext().getNext()); // skip the data to delete in the list
            --this.size;
            return true;
        }

        else
            return deleteRecursion(data, node.getNext());
    }


    /**
     * Searches for the index of the element.
     *
     * @param data the element to search
     * @return the index of the element, or -1 if not found
     */
    @Override
    public int search(T data) {
        return searchRecursion(data, this.head, 0);
    }

    private int searchRecursion(T data, Node<T> node, int index) {
        if (node == null) // Means the element is not present in this LinkedList
            return -1;

        else if (node.getData().equals(data))
            return index;

        else
            return searchRecursion(data, node.getNext(), ++index);
    }


    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || (index != 0 && index >= size))
            throw new IndexOutOfBoundsException();

        return getRecursion(index, this.head, 0);
    }

    private T getRecursion(int indexToReturn, Node<T> node, int currentIndex) {
        if (currentIndex == indexToReturn)
            return node.getData();

        return getRecursion(indexToReturn, node.getNext(), ++currentIndex);
    }

} // end of the class