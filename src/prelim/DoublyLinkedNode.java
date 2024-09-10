package prelim;

import java.util.Objects;

/**
 * Node for a doubly-linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class DoublyLinkedNode<T> {
    private T data;
    private DoublyLinkedNode<T> next;
    private DoublyLinkedNode<T> previous;

    /**
     * Default constructor.
     */
    public DoublyLinkedNode() {
    }

    /**
     * Constructs a node with the specified data.
     *
     * @param data the data to store in the node
     */
    public DoublyLinkedNode(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    /**
     * Constructs a node with the specified previous node, data, and next node.
     *
     * @param previous the previous node
     * @param data the data to store in the node
     * @param next the next node
     */
    public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next){
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    /**
     * Gets the data stored in the node.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data for the node.
     *
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the next node.
     *
     * @return the next node
     */
    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    /**
     * Sets the next node.
     *
     * @param next the next node to set
     */
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    /**
     * Gets the previous node.
     *
     * @return the previous node
     */
    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    /**
     * Sets the previous node.
     *
     * @param previous the previous node to set
     */
    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }


    /**
     * Checks if this node is equal to another object.
     *
     * @param o the object to compare with
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoublyLinkedNode<?> that = (DoublyLinkedNode<?>) o;

        return Objects.equals(data, that.data);
    }

    /**
     * Computes the hash code of this node.
     *
     * @return the hash code of the node
     */
    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    /**
     * Returns a string representation of this node.
     *
     * @return the string representation of the node's data
     */
    @Override
    public String toString() {
        return data.toString();
    }

}
