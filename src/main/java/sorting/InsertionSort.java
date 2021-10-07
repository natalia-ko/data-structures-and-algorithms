package sorting;

public class InsertionSort<T extends Comparable<T>> {

    public void insertionSort(int[] array) {
        for (int endOfSorted = 0; endOfSorted < array.length - 1; endOfSorted++) {
            int index = endOfSorted + 1;
            int temp = array[index];
            while (index >= 1 && array[index - 1] > temp) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = temp;
        }
    }

    // Realized for Generics
    public void insertionSort(T[] array) {
        for (int endOfSorted = 0; endOfSorted < array.length - 1; endOfSorted++) {
            int index = endOfSorted + 1;
            T temp = array[index];
            while (index >= 1 && array[index - 1].compareTo(temp) > 0) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = temp;
        }
    }

}
