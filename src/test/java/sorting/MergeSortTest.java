package sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static sorting.MergeSort.*;

public class MergeSortTest {
    @Test
    public void positiveTest() {
        int[] actual = new Random().ints(100, 1, 100).toArray();
        int[] expected = Arrays.stream(actual.clone()).sorted().toArray();

        MergeSort mS = new MergeSort();
        mS.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }
}
