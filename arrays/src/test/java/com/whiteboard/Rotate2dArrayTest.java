package com.whiteboard;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class Rotate2dArrayTest {
    @Test
    void rotate2dArray() {
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
            new Rotate2dArray().rotate2dArray(a[i]);
            System.out.println("\nRotated Array:");
            for (int row = 0; row < rows; ++row) {
                System.out.println(Arrays.toString(a[i][row]));
            }
        }
    }
}
