package arrays;

import java.util.Arrays;

/**
 * Compute the water collected between the bars of a histogram.
 */
public class HistogramWater {
    /**
     * The heights of the given histogram bars.
     */
    private int[] heights;

    /**
     * leftTallest[i] is the height of the tallest histogram
     * bar to the left of bar 'i'.
     */
    private int[] leftTallest;

    /**
     * rightTallest[i] is the height of the tallest histogram
     * bar to the right of bar 'i'.
     */
    private int[] rightTallest;

    /**
     * waterline[i] is the height of the waterline at bar 'i'.
     */
    private int[] waterline;

    /**
     * General constructor.
     *
     * @param heights An array specifying the height, in inches,
     * of each histogram bar.
     */
    HistogramWater(int[] heights) {
        this.heights = heights;
    }

    /**
     * Compute the water collected between the histogram bars.
     *
     * @return The amount, in inches, of water collected between
     * the histogram bars.
     */
    public int waterCollected() {
        findLeftTallest();
        findRightTallest();
        findWaterline();
        return findWaterCollected();
    }

    /**
     * For each histogram bar 'i', find the height of the tallest
     * histogram bar to the left of bar 'i'.
     */
    private void findLeftTallest() {
        leftTallest = new int[heights.length];
        int maxLeft = -1;
        for (int i = 0; i < heights.length; ++i) {
            maxLeft = Math.max(maxLeft, heights[i]);
            leftTallest[i] = maxLeft;
        }
    }

    /**
     * For each histogram bar 'i', find the height of the tallest
     * histogram bar to the right of bar 'i'.
     */
    private void findRightTallest() {
        this.rightTallest = new int[heights.length];
        int maxRight = -1;
        for (int i = heights.length - 1; i >= 0; --i) {
            maxRight = Math.max(maxRight, heights[i]);
            rightTallest[i] = maxRight;
        }
    }

    /**
     * For each histogram bar 'i', find the height of the waterline
     * at bar 'i'.
     */
    private void findWaterline() {
        this.waterline = new int[heights.length];
        for (int i = 0; i < heights.length; ++i) {
            waterline[i] = Math.min(leftTallest[i], rightTallest[i]);
        }
    }

    /**
     * Find the total amount of water collected by the histogram bars.
     *
     * @return The total amount of water collected.
     */
    private int findWaterCollected() {
        int waterCollected = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (waterline[i] > heights[i]) {
                waterCollected += waterline[i] - heights[i];
            }
        }
        return waterCollected;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test histogramWater():");
        System.out.println("======================");

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
            System.out.print("water collected = "
                    + new HistogramWater(testArray).waterCollected());
            System.out.println(" (should be " + waterCollected[i] + ")");
        }
    }
}
