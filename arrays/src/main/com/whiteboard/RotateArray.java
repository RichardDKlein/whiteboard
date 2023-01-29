package com.whiteboard;

/**
 * Rotate a square 2D array 90 degrees in the clockwise direction,
 * IN PLACE.
 */
public final class RotateArray {
    private RotateArray() {
    }

    /**
     * Rotate a square 2D array 90 degrees in the clockwise direction,
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
    public static void rotateArray(int[][] a) {
        transposeArray(a);
        int numRows = a.length;
        for (int row = 0; row < numRows; ++row) {
            reverseRow(a, row);
        }
    }

    private static void transposeArray(int[][] a) {
        int numRows = a.length;
        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < row; ++col) {
                int tmp = a[row][col];
                a[row][col] = a[col][row];
                a[col][row] = tmp;
            }
        }
    }

    private static void reverseRow(int[][] a, int row) {
        int numCols = a[0].length;
        int leftCol = 0;
        int rightCol = numCols - 1;
        while (leftCol < rightCol) {
            int tmp = a[row][leftCol];
            a[row][leftCol] = a[row][rightCol];
            a[row][rightCol] = tmp;
            ++leftCol;
            --rightCol;
        }
    }
}
