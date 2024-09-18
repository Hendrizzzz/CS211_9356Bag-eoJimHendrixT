package prelim.LinkedList;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Custom implementation of a node
 * @param <T> Type of the data of the node
 */
public class Node<T> {
    private Node<T> prev;
    private T data;
    private Node<T> next;


    /**
     * Default Constructor
     */
    public Node() {

    }

    /**
     * Constructor that constructs a node with a value data T
     * @param data the data to be set
     */
    public Node(T data){
        this.data = data;
        this.next = null;
    }


    /**
     * Constructs a node with a data and pointer to the next node values
     * @param data the data of the node to be constructed
     * @param next the pointer or address of the next node of the node to be created
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }


    /**
     * Getter method of data
     * @return the data of the node
     */
    public T getData() {
        return data;
    }


    /**
     * Setter method of data datafield
     * @param data the data to be set
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * Getter method of the next node of the object
     * @return the address of the next node
     */
    public Node<T> getNext() {
        return next;
    }


    /**
     * The setter method of the next node
     * @param next the address of the nest node to be set
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }


    /**
     * Equals method, checks if two objects are equal
     * @param o the object to be compared with, in this case Node<T>
     * @return boolean, true if the twi objects are equal, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        return Objects.equals(data, node.data);
    }


    /**
     * Modify the hashcode generator due to the equals method being modified
     * @return the new hashcode of this object
     */
    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }


    /**
     * Returns the string representation of the {@code data} object.
     *
     * @return A string representation of the data.
     */
    @Override
    public String toString() {
        return data.toString();
    }

} // end of the class