package java.com.whiteboard;

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
        leftTallest = new int[barHeights.length];
        int tallest = 0;
        for (int i = 0; i < barHeights.length; ++i) {
            leftTallest[i] = tallest;
            if (barHeights[i] > tallest) {
                tallest = barHeights[i];
            }
        }
    }

    private static void findRightTallest() {
        rightTallest = new int[barHeights.length];
        int tallest = 0;
        for (int i = barHeights.length - 1; i >= 0; --i) {
            rightTallest[i] = tallest;
            if (barHeights[i] > tallest) {
                tallest = barHeights[i];
            }
        }
    }

    private static void findWaterline() {
        waterline = new int[barHeights.length];
        for (int i = 0; i < barHeights.length; ++i) {
            waterline[i] = Math.min(leftTallest[i], rightTallest[i]);
        }
    }

    private static int computeTrappedWater() {
        int result = 0;
        for (int i = 0; i < barHeights.length; ++i) {
            if (waterline[i] > barHeights[i]) {
                result += waterline[i] - barHeights[i];
            }
        }
        return result;
    }
}
