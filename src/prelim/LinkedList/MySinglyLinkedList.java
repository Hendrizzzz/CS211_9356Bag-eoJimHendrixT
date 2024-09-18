package prelim.LinkedList;

import prelim.MyLinkedList;

import java.util.NoSuchElementException;

/**
 * A singly linked list implementation.
 *
 * @param <T> the type of elements held in this list
 */
public class MySinglyLinkedList<T> implements MyLinkedList<T> {

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
    @Override
    public T getHead() {
        return head == null ? null : this.head.getData();
    }

    /**
     * Returns the tail node.
     *
     * @return the tail node
     */
    @Override
    public T getTail() {
        return tail == null ? null : this.tail.getData();
    }


    /**
     * Returns the head node of the list.
     * Package modifier to hide access to the other classes
     *
     * @return The head node.
     */
    Node<T> getHeadNode() {
        return head;
    }

    /**
     * Returns the tail node of the list.
     * Package modfier to hide access to the other classes
     *
     * @return The tail node.
     */
    Node<T> getTailNode() {
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
        if (this.head == null) {
            this.head = new Node<>(data, null);
            this.tail = new Node<>(data, null);
        }
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
        if (this.head == null)
            return false;

        boolean isDeleted = true;

        if (this.size == 1 && this.head.getData().equals(data)){
            this.head = null;
            this.tail = null;
        }
        else if (this.head.getData().equals(data))
            this.head = this.head.getNext();
        else
            isDeleted = deleteRecursion(data, this.head, 1);

        if (isDeleted)
            --this.size;

        return isDeleted;
    }

    private boolean deleteRecursion(T data, Node<T> current, int index) {
        if (current.getNext() == null)
            return false;

        else if (current.getNext().getData().equals(data)){
            current.setNext(current.getNext().getNext()); // skip the data to delete in the list

            if (index == this.size - 1){
                this.tail = current;
                this.tail.setNext(null);
            }
            return true;
        }

        else
            return deleteRecursion(data, current.getNext(), ++index);
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
    @Override
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