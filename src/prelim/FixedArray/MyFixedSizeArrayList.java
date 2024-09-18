package prelim.FixedArray;

import prelim.ListOverflowException;
import prelim.MyArrayList;

import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 * A fixed-size array list implementation with a maximum capacity of 5 elements.
 * This class provides methods to insert, delete, search, and access elements within the list.
 *
 * @param <T> the type of elements in this list
 */
public class MyFixedSizeArrayList<T> implements MyArrayList<T> {

    private static final int FINAL_SIZE = 5;
    private final T[] array;
    private int size;


    /**
     * Constructs a new fixed-size array list with a capacity of 5.
     */
    @SuppressWarnings("unchecked")
    public MyFixedSizeArrayList() {
        array = (T[]) new Object[FINAL_SIZE];
        size = 0;
    }



    /**
     * Returns the number of elements currently in the list.
     *
     * @return the size of the list
     */
    @Override
    public int getSize() {
        return size;
    }


    /**
     * Inserts a new element into the list. If the list is full, a ListOverflowException is thrown.
     *
     * @param data the element to be inserted
     * @throws ListOverflowException if the list is full
     */
    @Override
    public void insert(T data) throws ListOverflowException {
        for (int i = 0; i < 5; i++){
            if (array[i] == null){
                array[i] = data;
                size++;
                return;
            }
        }

        // The List is full
        throw new ListOverflowException("List is full. Cannot insert new items. ");
    }


    /**
     * Retrieves an element from the list if it exists. If the element is not found, a NoSuchElementException is thrown.
     *
     * @param data the element to search for
     * @return the element if found
     * @throws NoSuchElementException if the element is not found in the list
     */
    @Override
    public T getElement(T data) throws NoSuchElementException {
        for (T object : array){
            if (object.equals(data)) return object;
        }

        // If there is no element 'data' found in the list
        throw new NoSuchElementException();
    }


    /**
     * Deletes an element from the list if it exists and shifts the remaining elements to fill the gap.
     *
     * @param data the element to delete
     * @return true if the element was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(T data) {
        if (this.size == 0)
            return false;

        for (int i = 0; i < 5; i++){
            if (array[i].equals(data)){
                array[i] = null;

                // Reposition the items
                for (int j = i; j < array.length - 1; j++){
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = null;
                size--;

                return true;
            }
        }
        return false;
    }



    /**
     * Searches for an element in the list and returns its index. If the element is not found, -1 is returned.
     *
     * @param data the element to search for
     * @return the index of the element if found, or -1 if not found
     */
    @Override
    public int search(T data) {
        for (int i = 0; i < 5; i++){
            if (array[i] != null && array[i].equals(data)){
                return i;
            }
        }
        return -1;
    }


    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T get (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }


    /**
     * Replaces the element at the specified index with a new element.
     *
     * @param index  the index of the element to replace
     * @param object the new element to set at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void set(int index, T object) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = object;
    }


    /**
     * Returns a string representation of the MyFixedSizeArrayList.
     *
     * @return A string showing the array and size of the list.
     */
    @Override
    public String toString() {
        return "MyFixedSizeArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

} // end of the class