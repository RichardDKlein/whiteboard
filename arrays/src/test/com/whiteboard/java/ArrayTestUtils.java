package com.whiteboard.java;

/**
 * Test utilities for arrays.
 */
public class ArrayTestUtils {
    private ArrayTestUtils() {
    }

    static void copyBitmap(char[][] original, char[][] copy) {
        int rows = original.length;
        int cols = original[0].length;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                copy[row][col] = original[row][col];
            }
        }
    }

    static void printBitmap(char[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                System.out.print(" " + a[row][col] + " ");
            }
            System.out.println();
        }
    }
}
