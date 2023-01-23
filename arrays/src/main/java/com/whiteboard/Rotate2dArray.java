package java.com.whiteboard;

/**
 * Rotate a 2D array 90 degrees in the clockwise direction,
 * IN PLACE.
 */
public final class Rotate2dArray {
    private Rotate2dArray() {
    }

    /**
     * Rotate a 2D array 90 degrees in the clockwise direction,
     * IN PLACE.
     *
     * We can use a small amount of extra storage, as long as it
     * is independent of the size of the array. That is, the storage
     * requirements of the algorithm must be O(1).
     *
     * Our algorithm is to transpose the array, and then to reverse
     * each row. Both operations can be done in place, by swapping
     * the appropriate elements.
     *
     * Execution time is O(n), where n is the number of elements
     * in the array.
     *
     * @param a The 2D array that is to be rotated.
     */
    public static void rotate2dArray(int[][] a) {
        transpose2dArray(a);
        for (int row = 0; row < a.length; ++row) {
            reverse1dArray(a[row]);
        }
    }

    private static void transpose2dArray(int[][] a) {
        for (int row = 0; row < a.length; ++row) {
            for (int col = 0; col < row; ++col) {
                int tmp = a[row][col];
                a[row][col] = a[col][row];
                a[col][row] = tmp;
            }
        }
    }

    private static void reverse1dArray(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            ++left;
            --right;
        }
    }
}
