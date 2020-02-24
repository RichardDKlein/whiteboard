package com.whiteboard;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TrappedWaterTest {
    @Test
    void trappedWater() {
        System.out.println();
        System.out.println("Test TrappedWater:");
        System.out.println("==================");

        int[][] heights = {
                {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 4, 0, 3, 0, 2, 0, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 3, 0, 7, 2, 0, 9, 0, 4, 3, 0, 5, 6, 0, 8, 0, 3}
        };

        int[] waterCollected = {
                20, 0, 56
        };

        for (int i = 0; i < heights.length; ++i) {
            int[] testArray = heights[i];
            System.out.println("heights = " + Arrays.toString(testArray));
            System.out.print("water collected = " +
                    new TrappedWater().trappedWater(testArray));
            System.out.println(" (should be " + waterCollected[i] + ")");
        }
    }
}
