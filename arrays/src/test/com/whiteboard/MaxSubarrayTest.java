package com.whiteboard;

import org.junit.Test;

public class MaxSubarrayTest {
    @Test
    public void maxSubarrayTest() {
        System.out.println();
        System.out.println("Test MaxSubarray:");
        System.out.println("=================");

        int[][] a = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {-1, -2, -3, -4, -5, -6, -7, -8, -9}
        };

        int[][] expected = {
                {3, 6},
                {0, 8},
                {0, 0}
        };

        for (int i = 0; i < a.length; ++i) {
            int[] maxSubarray = MaxSubarray.maxSubarray(a[i]);
            int maxStart = maxSubarray[0];
            int maxEnd = maxSubarray[1];
            assert(maxStart == expected[i][0]);
            assert(maxEnd == expected[i][1]);
            System.out.print("a: { ");
            for (int j = 0; j < a[i].length; ++j) {
                if (j == maxStart) {
                    System.out.print("[** ");
                }
                System.out.print(a[i][j] + " ");
                if (j == maxEnd) {
                    System.out.print("**] ");
                }
            }
            System.out.println("}");
            System.out.println("max subarray: [" +
                    maxStart + ", " + maxEnd + "]");
        }
    }
}
