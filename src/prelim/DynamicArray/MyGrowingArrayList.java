package prelim.DynamicArray;

import prelim.MyArrayList;

import java.util.NoSuchElementException;

/**
 * A dynamically resizing array list implementation.
 *
 * @param <T> The type of elements in this list.
 */
public class MyGrowingArrayList<T> implements MyArrayList<T> {

    private T[] array;
    private int size;

    /**
     * Creates a new MyGrowingArrayList with an initial capacity of 5.
     */
    @SuppressWarnings("unchecked")
    public MyGrowingArrayList() {
        array = (T[]) new Object[5];
        size = 0;
    }

    /**
     * Creates a new MyGrowingArrayList with the specified initial capacity.
     *
     * @param size The initial capacity of the list.
     */
    @SuppressWarnings("unchecked")
    public MyGrowingArrayList(int size) {
        this.size = size;
        array = (T[]) new Object[size];
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Inserts an element into the list.
     * If the list is full, it expands the list by five elements.
     *
     * @param data The element to be inserted.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void insert(T data) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[size + 5];

            // Copy elements to the new array
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }

        array[size] = data;
        size++;
    }

    /**
     * Retrieves an element from the list.
     *
     * @param data The element to retrieve.
     * @return The element if found.
     * @throws NoSuchElementException If the element is not found.
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        for (T object : array) {
            if (object != null && object.equals(data)) {
                return object;
            }
        }

        throw new NoSuchElementException("Element " + data + " not found in the list.");
    }

    /**
     * Removes an element from the list.
     *
     * @param data The element to remove.
     * @return True if the element was removed, false otherwise.
     */
    @Override
    public boolean delete(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(data)) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for an element in the list.
     *
     * @param data The element to search for.
     * @return The index of the element if found, -1 otherwise.
     */
    @Override
    public int search(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    @Override
    public T indexOf(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    /**
     * Replaces the element at the specified index with a new element.
     *
     * @param index  The index of the element to replace.
     * @param object The new element to set at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    @Override
    public void set(int index, T object) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = object;
    }

} // end of the class
