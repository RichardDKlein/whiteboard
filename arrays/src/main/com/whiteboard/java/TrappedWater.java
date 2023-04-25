package com.whiteboard.java;

/**
 * Compute the water collected between the bars of a bar graph.
 */
public final class TrappedWater {
    private TrappedWater() {
    }

    private static int[] barHeights;
    private static int numBars;
    private static int[] leftTallestBarHeights;
    private static int[] rightTallestBarHeights;
    private static int[] waterLine;

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
        saveCallingParameter(barHeights);
        findLeftTallestBarHeights();
        findRightTallestBarHeights();
        findWaterLine();
        return computeTrappedWater();
    }

    private static void saveCallingParameter(int[] barHeights) {
        TrappedWater.barHeights = barHeights;
        numBars = barHeights.length;
    }

    private static void findLeftTallestBarHeights() {
        leftTallestBarHeights = new int[numBars];
        int tallestSoFar = 0;
        for (int i = 0; i < numBars; ++i) {
            leftTallestBarHeights[i] = tallestSoFar;
            if (barHeights[i] > tallestSoFar) {
                tallestSoFar = barHeights[i];
            }
        }
    }

    private static void findRightTallestBarHeights() {
        rightTallestBarHeights = new int[numBars];
        int tallestSoFar = 0;
        for (int i = numBars - 1; i >= 0; --i) {
            rightTallestBarHeights[i] = tallestSoFar;
            if (barHeights[i] > tallestSoFar) {
                tallestSoFar = barHeights[i];
            }
        }
    }

    private static void findWaterLine() {
        waterLine = new int[numBars];
        for (int i = 0; i < numBars; ++i) {
            waterLine[i] = Math.min(leftTallestBarHeights[i], rightTallestBarHeights[i]);
        }
    }

    private static int computeTrappedWater() {
        int result = 0;
        for (int i = 0; i < numBars; ++i) {
            if (waterLine[i] > barHeights[i]) {
                result += waterLine[i] - barHeights[i];
            }
        }
        return result;
    }
}
