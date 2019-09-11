/**
 * Rotate a 2D array 90 degrees in the clockwise direction,
 * IN PLACE.
 */

package arrays;

import java.util.Arrays;

public final class Rotate2dArray {
    private Rotate2dArray() {}

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

    /**
     * Transpose a 2D array in place.
     *
     * Our algorithm is to swap each element below the major diagonal
     * with its mirror image above the major diagonal.
     */
    private static void transpose2dArray(int[][] a) {
        for (int row = 0; row < a.length; ++row) {
            for (int col = 0; col < row; ++col) {
                int temp = a[row][col];
                a[row][col] = a[col][row];
                a[col][row] = temp;
            }
        }
    }

    /**
     * Reverse a one-dimensional array in place.
     *
     * Our algorithm is to start at both ends of the array, and swap
     * elements as we work our way to the middle of the array.
     */
    private static void reverse1dArray(int[] a) {
        int begin = 0;
        int end = a.length - 1;
        while (begin < end) {
            int temp = a[begin];
            a[begin] = a[end];
            a[end] = temp;
            ++begin;
            --end;
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test rotate2dArray():");
        System.out.println("=====================");

        int[][][] a = {
                {
                        {1}
                },
                {
                        {1, 2},
                        {3, 4}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        { 1,  2,  3,  4},
                        { 5,  6,  7,  8},
                        { 9, 10, 11, 12},
                        {13, 14, 15, 16}
                },
                {
                        { 1,  2,  3,  4,  5},
                        { 6,  7,  8,  9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}
                }
        };
        for (int i = 0; i < a.length; ++i) {
            System.out.println("\nOriginal Array:");
            int rows = a[i].length;
            for (int row = 0; row < rows; ++row) {
                System.out.println(Arrays.toString(a[i][row]));
            }
            rotate2dArray(a[i]);
            System.out.println("\nRotated Array:");
            for (int row = 0; row < rows; ++row) {
                System.out.println(Arrays.toString(a[i][row]));
            }
        }
    }
}
