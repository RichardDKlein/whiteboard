/**
 * Rotate a 2D array 90 degrees in the clockwise direction,
 * IN PLACE.
 */

package com.whiteboard;

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

    private static void transpose2dArray(int[][] a) {
        for (int row = 0; row < a.length; ++row) {
            for (int col = 0; col < row; ++col) {
                int temp = a[row][col];
                a[row][col] = a[col][row];
                a[col][row] = temp;
            }
        }
    }

    private static void reverse1dArray(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test Rotate2dArray:");
        System.out.println("===================");

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
