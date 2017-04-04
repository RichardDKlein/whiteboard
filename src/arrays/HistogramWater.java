package arrays;

import java.util.Arrays;

/**
 * Compute the water collected between the bars of a histogram.
 */
public class HistogramWater {
    private int[] heights_;

    /**
     * @brief Constructor.
     *
     * @param heights An array specifying the height, in inches,
     * of each histogram bar.
     */
    public HistogramWater(int[] heights) {
        heights_ = heights;
    }

    /**
     * @brief Compute water collected.
     *
     * @return The amount, in inches, of water collected between
     * the histogram bars.
     */
    public int compute() {
        int[] leftTallest = new int[heights_.length];
        int maxLeft = -1;
        for (int i = 0; i < heights_.length; ++i) {
            maxLeft = Math.max(maxLeft, heights_[i]);
            leftTallest[i] = maxLeft;
        }
        int[] rightTallest = new int[heights_.length];
        int maxRight = -1;
        for (int i = heights_.length - 1; i >= 0; --i) {
            maxRight = Math.max(maxRight, heights_[i]);
            rightTallest[i] = maxRight;
        }
        int[] waterline = new int[heights_.length];
        for (int i = 0; i < heights_.length; ++i) {
            waterline[i] = Math.min(leftTallest[i], rightTallest[i]);
        }
        int waterCollected = 0;
        for (int i = 0; i < heights_.length; ++i) {
            if (waterline[i] > heights_[i]) {
                waterCollected += waterline[i] - heights_[i];
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

        for (int i = 0; i < heights.length; ++i) {
            int[] testArray = heights[i];
            System.out.println("heights = " + Arrays.toString(testArray));
            System.out.println("water collected = " + new HistogramWater(testArray).compute());
        }
    }
}
