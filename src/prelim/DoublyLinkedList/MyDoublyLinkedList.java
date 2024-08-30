package prelim.DoublyLinkedList;

import prelim.DoublyLinkedNode;
import prelim.MyList;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T> implements MyList<T> {
    private DoublyLinkedNode<T> root;
    private int size;

    public MyDoublyLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public MyDoublyLinkedList(T data) {
        this.root = new DoublyLinkedNode<>(data);
        this.root.setPrevious(null); // The first element in a doubly-LinkedList is none
        this.size = 1;
    }


    @Override
    public int getSize() {
        return this.size;
    }


    @Override
    public void insert(T data) {
        root = insertRecursion(data, this.root);
    }

    private DoublyLinkedNode<T> insertRecursion(T data, DoublyLinkedNode<T> node) {
        if (node == null){
            size++;
            return new DoublyLinkedNode<>(data);
        }

        if (size > 1) {
            node.setNext(insertRecursion(data, node.getNext()));
            node.getNext().setPrevious(node);
        }
        return node;
    }


    @Override
    public T getElement(T data) throws NoSuchElementException {
        return getElementRecursion(data, root);
    }

    private T getElementRecursion(T data, DoublyLinkedNode<T> node) {
        if (node == null)
            return null;

        else if (node.getData().equals(data))
            return node.getData();

        else
            return getElementRecursion(data, node.getNext());
    }


    @Override
    public boolean delete(T data) {
        if (this.root == null)
            return false;

        if (this.root.getData().equals(data)){
            this.root = null;
            this.size = 0;
            return true;
        }

        else
            return deleteRecursion(data, root, 0);
    }

    private boolean deleteRecursion(T data, DoublyLinkedNode<T> node, int newSize) {
        // Check if the next item in the list is the item to be deleted. If so, then set that pointer to null, cutting ties with the rest.
        if (node.getNext() != null && node.getNext().getData().equals(data)){
            node.setNext(null);
            this.size = newSize;
            return true;
        }

        else if (root.getNext() == null)
            return false;

        else
            return deleteRecursion(data, node.getNext(), ++newSize); // Count the newSize as we traverse into the nodes

    }


    @Override
    public int search(T data) {
        int index = 0;
        return searchRecursion(data, this.root, index);
    }

    // If the list is 3rd in the list, it will return its index, which is 2
    private int searchRecursion(T data, DoublyLinkedNode<T> node, int index) {
        if (node != null && node.getData().equals(data))
            return index;

        else if (node == null) // The Whole list is already searched, and the element to search is not present in the list
            return -1;

        else
            return searchRecursion(data, node.getNext(), ++index);
    }
}