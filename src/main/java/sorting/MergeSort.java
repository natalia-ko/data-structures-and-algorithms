package sorting;

public class MergeSort {

    public void mergeSort(int[] arrayToSort) {
        int n = arrayToSort.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(arrayToSort, 0, l, 0, mid);
        if (n - mid >= 0) {
            System.arraycopy(arrayToSort, mid, r, 0, n - mid);
        }
        mergeSort(l);
        mergeSort(r);
        merge(arrayToSort, l, r, mid, n - mid);
    }

    public static void merge(int[] array, int[] l, int[] r, int left, int right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {

            if (l[i] <= r[j])
                array[k++] = l[i++];
            else
                array[k++] = r[j++];

        }

        while (i < left)
            array[k++] = l[i++];

        while (j < right)
            array[k++] = r[j++];
    }
}








