package com.whiteboard;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MergeTwoSortedArraysTest {
    @Test
    void mergeTwoSortedArrays() {
        System.out.println();
        System.out.println("Test MergeTwoSortedArrays:");
        System.out.println("==========================");

        int[][] a1 = {
                {1, 3, 5, 7, 9},
                {1, 3, 5, 7, 9},
                {1, 3, 5, 7, 9, 11, 13, 15},
                {1, 2, 3, 4, 5}
        };

        int[][] a2 = {
                {2, 4, 6, 8, 10},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {2, 4, 6, 8, 10},
                {1, 2, 3, 4, 5}
        };

        int[][] expected = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15},
                {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}
        };

        for (int i = 0; i < a1.length; ++i) {
            System.out.println("a1 = " + Arrays.toString(a1[i]));
            System.out.println("a2 = " + Arrays.toString(a2[i]));
            int[] merged = MergeTwoSortedArrays.mergeTwoSortedArrays(a1[i], a2[i]);
            assert(Arrays.equals(merged,expected[i]));
            System.out.println("merged = " + Arrays.toString(merged));
        }
    }
}
