package com.whiteboard.java;

public final class TrappedWater {
    private static int numBars;
    private static int[] barHeights;
    private static int[] leftTallestBars;
    private static int[] rightTallestBars;
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
        init(barHeights);
        findLeftTallestBars();
        findRightTallestBars();
        findWaterline();
        return computeTrappedWater();
    }

    private static void init (int[] barHeights) {
        TrappedWater.barHeights = barHeights;
        numBars = barHeights.length;
        leftTallestBars = new int[numBars];
        rightTallestBars = new int[numBars];
        waterline = new int[numBars];
    }

    private static void findLeftTallestBars() {
        int tallestSoFar = 0;
        for (int bar = 0; bar < numBars; ++bar) {
            leftTallestBars[bar] = tallestSoFar;
            if (barHeights[bar] > tallestSoFar) {
                tallestSoFar = barHeights[bar];
            }
        }
    }

    private static void findRightTallestBars() {
        int tallestSoFar = 0;
        for (int bar = numBars - 1; bar >= 0; --bar) {
            rightTallestBars[bar] = tallestSoFar;
            if (barHeights[bar] > tallestSoFar) {
                tallestSoFar = barHeights[bar];
            }
        }
    }

    private static void findWaterline() {
        for (int bar = 0; bar < numBars; ++bar) {
            waterline[bar] = Math.min(leftTallestBars[bar],
                    rightTallestBars[bar]);
        }
    }

    private static int computeTrappedWater() {
        int result = 0;
        for (int bar = 0; bar < numBars; ++bar) {
            if (waterline[bar] > barHeights[bar]) {
                result += waterline[bar] - barHeights[bar];
            }
        }
        return result;
    }
}
