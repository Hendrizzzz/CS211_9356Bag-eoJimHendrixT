package prelim.DoublyLinkedList;

import prelim.DoublyLinkedNode;
import prelim.MyList;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T> implements MyList<T> {
     DoublyLinkedNode<T> head;
     DoublyLinkedNode<T> tail;
    private int size;


    public MyDoublyLinkedList() {
        this.size = 0;
    }

    public MyDoublyLinkedList(T data) {
        this.head = new DoublyLinkedNode<>(data);
        this.head.setPrevious(null); // The first element in a doubly-LinkedList is none
        this.size = 1;
    }


    @Override
    public int getSize() {
        return this.size;
    }


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


    @Override
    public T getElement(T data) throws NoSuchElementException {
        return getElementRecursion(data, head);
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
        if (this.head == null)
            return false;

        if (this.head.getData().equals(data)){
            this.head = null;
            this.size = 0;
            return true;
        }

        else
            return deleteRecursion(data, head);
    }

    private boolean deleteRecursion(T data, DoublyLinkedNode<T> node) {
        if (node.getNext() != null && node.getNext().getData().equals(data)){
            node.setNext(node.getNext().getNext());
            if (node.getNext() != null)
                node.getNext().setPrevious(node); // Set the previous of the new next node to the current node

            else {
                this.tail = node;
                node.setNext(head);
                head.setPrevious(node);
            }

            --this.size;
            return true;
        }

        else if (node.getNext() == null)
            return false;

        else
            return deleteRecursion(data, node.getNext()); // Count the newSize as we traverse into the nodes

    }


    @Override
    public int search(T data) {
        int index = 0;
        return searchRecursion(data, this.head, index);
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

    public T get(int index) {
        if (index < 0 || (index != 0 && index >= size))
            throw new IndexOutOfBoundsException();

        return getRecursion(index, this.head, 0);
    }

    private T getRecursion(int searchIndex, DoublyLinkedNode<T> current, int currentIndex) {
        if (searchIndex == currentIndex)
            return current.getData();

        return getRecursion(searchIndex, current.getNext(), ++currentIndex);
    }
}