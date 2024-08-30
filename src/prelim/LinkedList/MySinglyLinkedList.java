package prelim.LinkedList;

import prelim.MyList;

import java.util.NoSuchElementException;

public class MySinglyLinkedList<T> implements MyList<T> {


    private Node<T> root;

    private int size;

    public MySinglyLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public MySinglyLinkedList(T data) {
        this.root = new Node<>(data);
        this.size = 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insert(T data) {
        if (this.root == null)
            this.root = new Node<>(data);

        else
            insertRecursion(data, root);

        size++;
    }

    private void insertRecursion(T data, Node<T> root) {
        if (root.getNext() == null){
            root.setNext(new Node<>(data));
            return;
        }

        insertRecursion(data, root.getNext());
    }

    @Override
    public T getElement(T data) throws NoSuchElementException {
        return getElementRecursion(data, root);
    }

    private T getElementRecursion(T data, Node<T> root) {
        if (root == null)
            throw new NoSuchElementException("Element " + data + " is not in the list. ");

        else if (root.getData().equals(data))
            return root.getData();

        else
            return getElementRecursion(data, root.getNext());
    }

    @Override
    public boolean delete(T data) {
        if (this.root == null){
            return false;
        }

        if (root.getData().equals(data)){
            root = null;
            this.size = 0;
            return true;
        }

        else
            return deleteRecursion(data, root, 0);
    }

    private boolean deleteRecursion(T data, Node<T> root, int newSize) {
        if (root.getNext() == null)
            return false;

        else if (root.getNext().getData().equals(data)){
            root.setNext(null); // Deleting an element here means if you delete the 4th element, 5th and so on will also be deleted
            this.size = newSize;
            return true;
        }

        else
            return deleteRecursion(data, root.getNext(), ++newSize); // Count the newSize as we traverse into the nodes
    }

    @Override
    public int search(T data) {
        int index = 0;
        return searchRecursion(data, root, index);
    }

    private int searchRecursion(T data, Node<T> root, int index) {
        if (root == null) // Means the element is not present in this LinkedList
            return -1;

        else if (root.getData().equals(data))
            return index;

        else
            return searchRecursion(data, root.getNext(), ++index);

    }
}