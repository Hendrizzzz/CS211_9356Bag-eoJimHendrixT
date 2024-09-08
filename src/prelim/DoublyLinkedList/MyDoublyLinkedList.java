package prelim.DoublyLinkedList;

import prelim.DoublyLinkedNode;
import prelim.LinkedList.Node;
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


    public DoublyLinkedNode<T> getHead() {
        return head;
    }

    public DoublyLinkedNode<T> getTail() {
        return tail;
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


    @Override
    public boolean delete(T data) {
        if (this.head == null) // return immediately if the list has no elements
            return false;

        boolean isDeleted = true;

        // Add a shortcut if the data to be deleted is from one of the ends
        if (this.head.getData().equals(data)) // If from the head
            this.head = head.getNext();
        else if (this.tail.getData().equals(data)) { // If from the tail
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


}