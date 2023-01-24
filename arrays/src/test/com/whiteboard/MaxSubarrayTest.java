package com.whiteboard;

import org.junit.Test;

import static com.whiteboard.MaxSubarray.Interval;

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

        Interval[] expected = {
                new Interval(3, 6),
                new Interval(0, 8),
                new Interval(0, 0)
        };

        for (int i = 0; i < a.length; ++i) {
            Interval maxSubarray = MaxSubarray.maxSubarray(a[i]);
            int maxStart = maxSubarray.start;
            int maxEnd = maxSubarray.end;
            assert(maxStart == expected[i].start);
            assert(maxEnd == expected[i].end);
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
