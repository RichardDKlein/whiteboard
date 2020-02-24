package com.whiteboard;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

class MaxSubarrayTest {
    @Test
    void maxSubarray() {
        System.out.println();
        System.out.println("Test MaxSubarray:");
        System.out.println("=================");

        int[][] a = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {-1, -2, -3, -4, -5, -6, -7, -8, -9}
        };

        for (int i = 0; i < a.length; ++i) {
            Pair<Integer, Integer> maxSubarray =
                    new MaxSubarray().maxSubarray(a[i]);
            int maxStart = maxSubarray.getKey();
            int maxEnd = maxSubarray.getValue();
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
