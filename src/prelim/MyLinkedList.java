package prelim;

/**
 * Interface for a generic linked list.
 *
 * @param <T> the type of elements in this list
 */
public interface MyLinkedList<T> extends MyList<T> {

    /**
     * Returns the head element of the linked list.
     *
     * @return the head element
     */
    T getHead();

    /**
     * Returns the tail element of the linked list.
     *
     * @return the tail element
     */
    T getTail();

    /**
     * Returns the element at the specified position in the linked list.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);
}
