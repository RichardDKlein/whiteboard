package com.whiteboard;

import java.util.Arrays;

/**
 * Compute the water collected between the bars of a bar graph.
 */
public final class TrappedWater {
    private TrappedWater() {}

    private static int[] barHeights_;
    private static int[] leftTallest_;  // height of tallest bar to the left
    private static int[] rightTallest_; // height of tallest bar to the right
    private static int[] waterline_;    // waterline at each bar

    /**
     * Compute the water collected between the bars of a bar graph.
     *
     * The computation proceeds in four passes thru the bars.
     *
     * The first two passes compute, for each bar 'i', the height
     * of the tallest bar to the left and right of bar 'i',
     * respectively.
     *
     * The third pass computes, for each bar 'i', the height of the
     * waterline at bar 'i'. (This will be the minimum of the left
     * and right tallest bars for bar 'i'.)
     *
     * The fourth and final pass computes, for each bar 'i', the
     * amount of water trapped above bar 'i'. (This will simply be
     * the difference between the waterline at bar 'i' and the height
     * of bar 'i'.)
     *
     * Running time = O(n) + O(n) + O(n) + O(n) = O(n).
     *
     * @return The amount, in inches, of water trapped between the
     * bars of the bar graph.
     */
    public static int trappedWater(int[] barHeights) {
        barHeights_ = barHeights;
        findLeftTallest();
        findRightTallest();
        findWaterline();
        return computeTrappedWater();
    }

    private static void findLeftTallest() {
        leftTallest_ = new int[barHeights_.length];
        int leftTallest = -1;
        for (int i = 0; i < barHeights_.length; ++i) {
            if (barHeights_[i] > leftTallest) {
                leftTallest = barHeights_[i];
            }
            leftTallest_[i] = leftTallest;
        }
    }

    private static void findRightTallest() {
        rightTallest_ = new int[barHeights_.length];
        int rightTallest = -1;
        for (int i = barHeights_.length - 1; i >= 0; --i) {
            if (barHeights_[i] > rightTallest) {
                rightTallest = barHeights_[i];
            }
            rightTallest_[i] = rightTallest;
        }
    }

    private static void findWaterline() {
        waterline_ = new int[barHeights_.length];
        for (int i = 0; i < barHeights_.length; ++i) {
            waterline_[i] = Math.min(leftTallest_[i], rightTallest_[i]);
        }
    }

    private static int computeTrappedWater() {
        int trappedWater = 0;
        for (int i = 0; i < barHeights_.length; ++i) {
            if (waterline_[i] > barHeights_[i]) {
                trappedWater += waterline_[i] - barHeights_[i];
            }
        }
        return trappedWater;
    }

    public static void test() {
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
            System.out.print("water collected = " + trappedWater(testArray));
            System.out.println(" (should be " + waterCollected[i] + ")");
        }
    }
}
