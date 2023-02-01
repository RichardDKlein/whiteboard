package com.whiteboard;

/**
 * Compute the water collected between the bars of a bar graph.
 */
public final class TrappedWater {
    private TrappedWater() {
    }

    private static int[] barHeights;
    private static int[] leftTallest;
    private static int[] rightTallest;
    private static int[] waterline;

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
        TrappedWater.barHeights = barHeights;
        findLeftTallest();
        findRightTallest();
        findWaterline();
        return computeTrappedWater();
    }

    private static void findLeftTallest() {
        int numBars = barHeights.length;
        leftTallest = new int[numBars];
        int tallestSoFar = 0;
        for (int i = 0; i < numBars; ++i) {
            if (barHeights[i] > tallestSoFar) {
                tallestSoFar = barHeights[i];
            }
            leftTallest[i] = tallestSoFar;
        }
    }

    private static void findRightTallest() {
        int numBars = barHeights.length;
        rightTallest = new int[numBars];
        int tallestSoFar = 0;
        for (int i = numBars - 1; i >= 0; --i) {
            if (barHeights[i] > tallestSoFar) {
                tallestSoFar = barHeights[i];
            }
            rightTallest[i] = tallestSoFar;
        }
    }

    private static void findWaterline() {
        int numBars = barHeights.length;
        waterline = new int[numBars];
        for (int i = 0; i < numBars; ++i) {
            waterline[i] = Math.min(leftTallest[i], rightTallest[i]);
        }
    }

    private static int computeTrappedWater() {
        int result = 0;
        int numBars = barHeights.length;
        for (int i = 0; i < numBars; ++i) {
            if (waterline[i] > barHeights[i]) {
                result += waterline[i] - barHeights[i];
            }
        }
        return result;
    }
}
