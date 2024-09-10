package prelim;

import java.util.NoSuchElementException;

/**
 * Interface for a generic list.
 *
 * @param <E> the type of elements in this list
 */
public interface MyList<E> {

    /**
     * Gets the number of elements in the list.
     *
     * @return the size of the list
     */
    public int getSize();

    /**
     * Inserts an element into the list.
     *
     * @param data the element to insert
     * @throws ListOverflowException if the list is full
     */
    public void insert(E data) throws ListOverflowException;

    /**
     * Retrieves an element from the list.
     *
     * @param data the element to retrieve
     * @return the element if found
     * @throws NoSuchElementException if the element is not found
     */
    public E getElement(E data) throws NoSuchElementException;

    /**
     * Deletes an element from the list.
     *
     * @param data the element to delete
     * @return true if the element was deleted, false otherwise
     */
    public boolean delete(E data);

    /**
     * Searches for an element in the list.
     *
     * @param data the element to search for
     * @return the index of the element, or -1 if not found
     */
    public int search(E data);
}
