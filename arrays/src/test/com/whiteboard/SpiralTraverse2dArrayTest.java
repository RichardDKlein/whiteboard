package com.whiteboard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SpiralTraverse2dArrayTest {
    @Test
    void spiralTraverse2dArrayTest() {
        System.out.println();
        System.out.println("Test SpiralTraverse2dArray:");
        System.out.println("===========================");

        int[][][] a = {
                {
                        {1}
                },
                {
                        {1, 2, 3, 4}
                },
                {
                        {1},
                        {2},
                        {3},
                        {4}
                },
                {
                        {1, 2},
                        {3, 4}
                },
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8}
                },
                {
                        {1, 2},
                        {3, 4},
                        {5, 6},
                        {7, 8}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        { 1,  2,  3,  4,  5},
                        { 6,  7,  8,  9, 10},
                        {11, 12, 13, 14, 15}
                },
                {
                        { 1,  2,  3},
                        { 4,  5,  6},
                        { 7,  8,  9},
                        {10, 11, 12},
                        {13, 14, 15}
                },
                {
                        { 1,  2,  3,  4},
                        { 5,  6,  7,  8},
                        { 9, 10, 11, 12},
                        {13, 14, 15, 16}
                },
                {
                        { 1,  2,  3,  4,  5,  6,  7},
                        { 8,  9, 10, 11, 12, 13, 14},
                        {15, 16, 17, 18, 19, 20, 21},
                        {22, 23, 24, 25, 26, 27, 28}
                },
                {
                        { 1,  2,  3,  4},
                        { 5,  6,  7,  8},
                        { 9, 10, 11, 12},
                        {13, 14, 15, 16},
                        {17, 18, 19, 20},
                        {21, 22, 23, 24},
                        {25, 26, 27, 28}
                }
        };

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(1, 2, 3, 4));
        expected.add(Arrays.asList(1, 2, 3, 4));
        expected.add(Arrays.asList(1, 2, 4, 3));
        expected.add(Arrays.asList(1, 2, 3, 4, 8, 7, 6, 5));
        expected.add(Arrays.asList(1, 2, 4, 6, 8, 7, 5, 3));
        expected.add(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
        expected.add(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 14, 13,
                12, 11, 6, 7, 8, 9));
        expected.add(Arrays.asList(1, 2, 3, 6, 9, 12, 15, 14, 13,
                10, 7, 4, 5, 8, 11));
        expected.add(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14,
                13, 9, 5, 6, 7, 11, 10));
        expected.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 14, 21,
                28, 27, 26, 25, 24, 23, 22, 15, 8, 9, 10, 11, 12,
                13, 20, 19, 18, 17, 16));
        expected.add(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 20, 24,
                28, 27, 26, 25, 21, 17, 13, 9, 5, 6, 7, 11, 15, 19,
                23, 22, 18, 14, 10));

        for (int i = 0; i < a.length; ++i) {
            System.out.println("\nArray:");
            int rows = a[i].length;
            for (int row = 0; row < rows; ++row) {
                System.out.println(Arrays.toString(a[i][row]));
            }
            List<Integer> spiral = SpiralTraverse2dArray
                    .spiralTraverse2dArray(a[i]);
            assert(spiral.equals(expected.get(i)));
            System.out.println("\nSpiral Traversal:");
            System.out.println(spiral.toString());
        }
    }
}
