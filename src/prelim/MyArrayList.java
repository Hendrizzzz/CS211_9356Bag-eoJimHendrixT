package prelim;

/**
 * Interface for a generic array list.
 *
 * @param <T> the type of elements in this list
 */
public interface MyArrayList<T> extends MyList<T> {

    /**
     * Returns the element at the specified position in the array list.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);

    /**
     * Replaces the element at the specified position in the array list with the specified element.
     *
     * @param index the index of the element to replace
     * @param object the element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void set(int index, T object);
}
