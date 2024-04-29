package com.whiteboard.java;

import java.util.Arrays;

public final class TrappedWater {
    /**
     * Compute the water collected between the bars of a bar graph.
     *
     * The computation proceeds in four passes through the bars.
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
        int[] leftTallestBars = findLeftTallestBars(barHeights);
        int[] rightTallestBars = findRightTallestBars(barHeights);
        int[] waterLine = computeWaterLine(leftTallestBars, rightTallestBars);
        return computeTrappedWater(barHeights, waterLine);
    }

    private static int[] findLeftTallestBars(int[] barHeights) {
        int numBars = barHeights.length;
        int[] leftTallestBars = new int[numBars];
        int tallestSoFar = 0;
        for (int i = 0; i < numBars; i++) {
            leftTallestBars[i] = tallestSoFar;
            if (barHeights[i] > tallestSoFar) {
                tallestSoFar = barHeights[i];
            }
        }
        return leftTallestBars;
    }

    private static int[] findRightTallestBars(int[] barHeights) {
        int numBars = barHeights.length;
        int[] rightTallestBars = new int[numBars];
        int tallestSoFar = 0;
        for (int i = numBars - 1; i >= 0; i--) {
            rightTallestBars[i] = tallestSoFar;
            if (barHeights[i] > tallestSoFar) {
                tallestSoFar = barHeights[i];
            }
        }
        return rightTallestBars;
    }

    private static int[] computeWaterLine(int[] leftTallestBars, int[] rightTallestBars) {
        int numBars = leftTallestBars.length;
        int[] waterLine = new int[numBars];
        for (int i = 0; i < waterLine.length; i++) {
            waterLine[i] = Math.min(leftTallestBars[i], rightTallestBars[i]);
        }
        return waterLine;
    }

    private static int computeTrappedWater(int[] barHeights, int[] waterLine) {
        int numBars = barHeights.length;
        int trappedWater = 0;
        for (int i = 0; i < numBars; i++) {
            if (waterLine[i] > barHeights[i]) {
                trappedWater += waterLine[i] - barHeights[i];
            }
        }
        return trappedWater;
    }
}
