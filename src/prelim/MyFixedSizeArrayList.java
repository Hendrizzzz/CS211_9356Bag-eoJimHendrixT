package prelim;

import java.util.NoSuchElementException;

public class MyFixedSizeArrayList<T> implements MyList<T> {

    private final T[] array;

    @SuppressWarnings("unchecked")
    public MyFixedSizeArrayList() {
        array = (T[]) new Object[5];
    }

    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public void insert(T data) throws ListOverflowException {
        for (int i = 0; i < 5; i++){
            if (array[i] == null){
                array[i] = data;
                return;
            }
        }

        // The List is full
        throw new ListOverflowException("List is full. Cannot insert new items. ");
    }

    @Override
    public T getElement(T data) throws NoSuchElementException {
        for (T object : array){
            if (object.equals(data)) return object;
        }

        // If there is no element 'data' found in the list
        throw new NoSuchElementException();
    }

    @Override
    public boolean delete(T data) {
        for (int i = 0; i < 5; i++){
            if (array[i].equals(data)){
                array[i] = null;

                // Reposition the items
                for (int j = i; j < array.length - 1; j++){
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = null;

                return true;
            }
        }
        return false;
    }

    @Override
    public int search(T data) {
        for (int i = 0; i < 5; i++){
            if (array[i] != null && array[i].equals(data)){
                return i;
            }
        }
        return -1;
    }
}