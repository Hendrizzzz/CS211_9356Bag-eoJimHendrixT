package prelim.LinkedList;

import prelim.MyList;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public MySinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MySinglyLinkedList(T data) {
        // Set the first element both head and tail
        this.head = new Node<>(data);
        this.head.setNext(null);
        this.tail = new Node<>(data);
        this.tail.setNext(null);
        this.size = 1;
    }


    @Override
    public int getSize() {
        return size;
    }

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
            node.setNext(new Node<>(data));
            return;
        }

        insertRecursion(data, node.getNext());
    }

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

    @Override
    public int search(T data) {
        int index = 0;
        return searchRecursion(data, this.head, index);
    }

    private int searchRecursion(T data, Node<T> node, int index) {
        if (node == null) // Means the element is not present in this LinkedList
            return -1;

        else if (node.getData().equals(data))
            return index;

        else
            return searchRecursion(data, node.getNext(), ++index);
    }


    public T get(int index) {
        if (index < 0 || (index != 0 && index >= size))
            throw new IndexOutOfBoundsException();

        // Check what end is closest to the index, head or tail? then start the search on that end
        if (index < this.size - index)
            return getRecursion(index, this.head, 0);
        else
            return getRecursionReversed(index, this.tail, this.size - 1);
    }

    private T getRecursion(int indexToReturn, Node<T> node, int currentIndex) {
        if (currentIndex == indexToReturn)
            return node.getData();

        return getRecursion(indexToReturn, node.getNext(), ++currentIndex);
    }

    private T getRecursionReversed(int indexToReturn, Node<T> node, int currentIndex) {
        if (currentIndex == indexToReturn)
            return node.getData();

        return getRecursion(indexToReturn, node.getNext(), --currentIndex);
    }
}