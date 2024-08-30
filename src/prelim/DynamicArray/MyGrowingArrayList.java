package prelim.DynamicArray;

import prelim.MyList;

import java.util.NoSuchElementException;

public class MyGrowingArrayList<T> implements MyList<T> {

    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyGrowingArrayList(){
        array = (T[]) new Object[5];
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insert(T data) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[size + 5]; // Create a new object with size + 5

            // Replace manually
            for (int i = 0; i < size; i++){
                newArray[i] = array[i];
            }

            array = newArray; // Reference it back to 'array'
        }
        array[size - 1] = data;
        size++;
    }

    @Override
    public T getElement(T data) throws NoSuchElementException {
        for (T object : array){
            if (object.equals(data)) return object;
        }

        throw new NoSuchElementException("Element " + data + " not found in the list.");
    }

    @Override
    public boolean delete(T data) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(data)){
                array[i] = null;

                // Reposition the elements
                for (int j = i; j < size - 1; j++){
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public int search(T data) {
        for (int i = 0; i < size; i++){
            if (array[i].equals(data)) return i;
        }
        return -1;
    }
}