package arrays;

import java.util.Arrays;

/**
 * Compute the water collected between the bars of a bar graph.
 */
public final class TrappedWater {
    private TrappedWater() {}

    /**
     * The heights of the given bars.
     */
    private static int[] barHeights;

    /**
     * leftTallest[i] is the height of the tallest bar to the left
     * of bar 'i'.
     */
    private static int[] leftTallest;

    /**
     * rightTallest[i] is the height of the tallest bar to the right
     * of bar 'i'.
     */
    private static int[] rightTallest;

    /**
     * waterline[i] is the height of the waterline at bar 'i'.
     */
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
    public static int trappedWater(int[] heights) {
        barHeights = heights;
        findLeftTallest();
        findRightTallest();
        findWaterline();
        return computeTrappedWater();
    }

    /**
     * For each bar 'i', find the height of the tallest bar to the
     * left of bar 'i'.
     */
    private static void findLeftTallest() {
        leftTallest = new int[barHeights.length];
        int maxLeft = -1;
        for (int i = 0; i < barHeights.length; ++i) {
            maxLeft = Math.max(maxLeft, barHeights[i]);
            leftTallest[i] = maxLeft;
        }
    }

    /**
     * For each bar 'i', find the height of the tallest bar to the
     * right of bar 'i'.
     */
    private static void findRightTallest() {
        rightTallest = new int[barHeights.length];
        int maxRight = -1;
        for (int i = barHeights.length - 1; i >= 0; --i) {
            maxRight = Math.max(maxRight, barHeights[i]);
            rightTallest[i] = maxRight;
        }
    }

    /**
     * For each bar 'i', find the height of the waterline at bar 'i'.
     */
    private static void findWaterline() {
        waterline = new int[barHeights.length];
        for (int i = 0; i < barHeights.length; ++i) {
            waterline[i] = Math.min(leftTallest[i], rightTallest[i]);
        }
    }

    /**
     * Compute the total amount of water trapped by the bars.
     *
     * @return The total amount of water trapped.
     */
    private static int computeTrappedWater() {
        int trappedWater = 0;
        for (int i = 0; i < barHeights.length; ++i) {
            if (waterline[i] > barHeights[i]) {
                trappedWater += waterline[i] - barHeights[i];
            }
        }
        return trappedWater;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test trappedWater():");
        System.out.println("====================");

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
