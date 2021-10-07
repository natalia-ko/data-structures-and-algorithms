package sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class BubbleSortTest {
    @Test
    public void sort(){
        int[] array = new Random().ints(100, 1, 100).toArray();
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(array);
        boolean sorted = IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
        assertTrue(sorted);
    }

    @Test
    public void sortRevertedArray() {
        int[] array = new int[]{9,8,7,6,5,4,3,2,1,0};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(array);
        boolean sorted = IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
        assertTrue(sorted);
    }
}
