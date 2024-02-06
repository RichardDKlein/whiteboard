package com.whiteboard.java;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println();
        System.out.println("Test BubbleSort:");
        System.out.println("================");
    }

    @Before
    public void beforeEachTest() {
    }

    @Test
    public void arrayWithOneElement() {
        int[] a = new int[] {1};
        int[] expected = new int[] {1};
        doTest(a, expected);
    }

    @Test
    public void alreadySortedArray() {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        doTest(a, expected);
    }

    @Test
    public void worstCase() {
        int[] a = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        doTest(a, expected);
    }

    @Test
    public void averageCase1() {
        int[] a = new int[] {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        doTest(a, expected);
    }

    @Test
    public void averageCase2() {
        int[] a = new int[] {4, 2, 3, 1, 7, 5, 10, 9, 8, 6};
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        doTest(a, expected);
    }

    public void doTest(int[] a, int[] expected) {
        int[] aCopy = Arrays.copyOf(a, a.length);
        BubbleSort.bubbleSort(aCopy);
        assert(Arrays.equals(expected, aCopy));
        System.out.printf("bubbleSort(%s) = %s\n",
                Arrays.toString(a), Arrays.toString(aCopy));
    }
}
