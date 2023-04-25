package com.whiteboard.java;

import org.junit.Test;

import java.util.Arrays;

public class TrappedWaterTest {
    @Test
    public void trappedWaterTest() {
        System.out.println();
        System.out.println("Test TrappedWater:");
        System.out.println("==================");

        int[][] heights = {
                {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 4, 0, 3, 0, 2, 0, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 3, 0, 7, 2, 0, 9, 0, 4, 3, 0, 5, 6, 0, 8, 0, 3}
        };

        int[] expected = {
                20, 0, 56
        };

        for (int i = 0; i < heights.length; ++i) {
            int[] testArray = heights[i];
            int trappedWater = TrappedWater.trappedWater(testArray);
            assert(trappedWater == expected[i]);
            System.out.println("heights = " + Arrays.toString(testArray));
            System.out.println("trapped water = " + trappedWater);
        }
    }
}
