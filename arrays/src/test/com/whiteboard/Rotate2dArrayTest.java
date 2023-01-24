package com.whiteboard;

import org.junit.Test;

import java.util.Arrays;

public class Rotate2dArrayTest {
    @Test
    public void rotate2dArrayTest() {
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

        int[][][] expected = {
                {
                        {1}
                },
                {
                        {3, 1},
                        {4, 2}
                },
                {
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}
                },
                {
                        {13,  9,  5, 1},
                        {14, 10,  6, 2},
                        {15, 11,  7, 3},
                        {16, 12,  8, 4}
                },
                {
                        {21, 16, 11,  6, 1},
                        {22, 17, 12,  7, 2},
                        {23, 18, 13,  8, 3},
                        {24, 19, 14,  9, 4},
                        {25, 20, 15, 10, 5}
                }
        };

        for (int i = 0; i < a.length; ++i) {
            System.out.println("\nOriginal Array:");
            int rows = a[i].length;
            for (int row = 0; row < rows; ++row) {
                System.out.println(Arrays.toString(a[i][row]));
            }
            Rotate2dArray.rotate2dArray(a[i]);
            for (int j = 0; j < rows; ++j) {
                assert(Arrays.equals(a[i][j], expected[i][j]));
            }
            System.out.println("\nRotated Array:");
            for (int row = 0; row < rows; ++row) {
                System.out.println(Arrays.toString(a[i][row]));
            }
        }
    }
}
