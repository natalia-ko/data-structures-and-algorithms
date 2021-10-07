package sorting;

public class SelectionSort {

    public void selectionSort(int[] array) {
        for (int startUnsorted = 0; startUnsorted < array.length; startUnsorted++) {
            int minInd = startUnsorted;
            for (int i = startUnsorted + 1; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            if (array[startUnsorted] > array[minInd]) {
                swap(array, startUnsorted, minInd);
            }
        }
    }


    public void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}
