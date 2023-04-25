package com.whiteboard.java;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {
    @Test
    public void bubbleSortTest() {
        System.out.println();
        System.out.println("Test BubbleSort:");
        System.out.println("================");

        int[][] testArrays = {
                {1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {2, 1, 4, 3, 6, 5, 8, 7, 10, 9},
                {4, 2, 3, 1, 7, 5, 8, 6, 10, 9}
        };

        int[][] expected = {
                {1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < testArrays.length; ++i) {
            int[] copyOfTestArray = Arrays.copyOf(testArrays[i], testArrays[i].length);
            BubbleSort.bubbleSort(copyOfTestArray);
            assert(Arrays.equals(expected[i], copyOfTestArray));
            System.out.println("bubbleSort(\""
                    + Arrays.toString(testArrays[i]) + "\") = \""
                    + Arrays.toString(copyOfTestArray) + "\"");
        }
    }
}
