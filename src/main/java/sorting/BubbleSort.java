package sorting;

public class BubbleSort {
    public void bubbleSort(int[] array) {
        for (int endUnsorted = array.length - 1; endUnsorted > 0; endUnsorted--) {
            for (int i = 0; i < endUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }
    private void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

}
