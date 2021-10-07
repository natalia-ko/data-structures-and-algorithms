package searching;

public class BinarySearch {

    public int binarySearch(int[] array, int key) {
        int lower = 0;
        int upper = array.length - 1;
        int currentInd;

        while (true) {
            currentInd = (upper + lower) / 2;
            if (array[currentInd] == key) return currentInd;
            else if (lower > upper) return -1;
            else {
                if (array[currentInd] < key) {
                    lower = currentInd + 1;
                } else {
                    upper = currentInd - 1;
                }
            }
        }
    }
}


