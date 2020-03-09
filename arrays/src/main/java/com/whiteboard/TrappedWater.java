package com.whiteboard;

import java.util.Arrays;

/**
 * Compute the water collected between the bars of a bar graph.
 */
public class TrappedWater {
    private int[] barHeights_;
    private int[] leftTallest_; // height of tallest bar to the left
    private int[] rightTallest_; // height of tallest bar to the right
    private int[] waterline_; // waterline at each bar

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
    public int trappedWater(int[] barHeights) {
        barHeights_ = barHeights;
        findLeftTallest();
        findRightTallest();
        findWaterline();
        return computeTrappedWater();
    }

    private void findLeftTallest() {
        leftTallest_ = new int[barHeights_.length];
        int leftTallest = 0;
        for (int i = 0; i < barHeights_.length; ++i) {
            leftTallest_[i] = leftTallest;
            if (barHeights_[i] > leftTallest) {
                leftTallest = barHeights_[i];
            }
        }
    }

    private void findRightTallest() {
        rightTallest_ = new int[barHeights_.length];
        int rightTallest = 0;
        for (int i = barHeights_.length - 1; i >= 0; --i) {
            rightTallest_[i] = rightTallest;
            if (barHeights_[i] > rightTallest) {
                rightTallest = barHeights_[i];
            }
        }
    }

    private void findWaterline() {
        waterline_ = new int[barHeights_.length];
        for (int i = 0; i < barHeights_.length; ++i) {
            waterline_[i] = Math.min(leftTallest_[i], rightTallest_[i]);
            if (barHeights_[i] > waterline_[i]) {
                waterline_[i] = barHeights_[i];
            }
        }
    }

    private int computeTrappedWater() {
        int trappedWater = 0;
        for (int i = 0; i < barHeights_.length; ++i) {
            trappedWater += waterline_[i] - barHeights_[i];
        }
        return trappedWater;
    }
}
