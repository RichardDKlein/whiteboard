package com.whiteboard;

import org.junit.jupiter.api.Test;

class FloodFillRecursiveTest {
    @Test
    void floodFillRecursiveTest() {
        System.out.println();
        System.out.println("Test floodFillRecursive:");
        System.out.println("========================");

        char[][] a = {
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ',' ',' ',' ','@','@','@','@','@','@','@',' ',},
                {' ',' ','@','@','@','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ','@','@','@','@','@','@','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
                {' ',' ','@',' ',' ','@',' ',' ',' ',' ','@',' ',' ',' ',' ',' ',},
                {' ',' ','@',' ',' ','@',' ',' ',' ','@',' ','@',' ',' ',' ',' ',},
                {' ',' ','@','@','@','@',' ',' ','@',' ',' ',' ','@',' ',' ',' ',},
                {' ',' ',' ',' ',' ',' ',' ','@',' ',' ',' ',' ',' ','@',' ',' ',},
                {' ',' ',' ',' ',' ',' ','@','@','@','@','@','@','@','@','@',' ',},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',}
        };

        int[] row = {
                1,
                4,
                3,
                7,
                9
        };
        int[] col = {
                1,
                4,
                12,
                8,
                10
        };
        int rows = a.length;
        int cols = a[0].length;
        char[][] copy = new char[rows][cols];
        for (int i = 0; i < row.length; ++i) {
            System.out.println("\nBEFORE flood fill:");
            ArrayTestUtils.copyBitmap(a, copy);
            char tmp = a[row[i]][col[i]];
            a[row[i]][col[i]] = 'S';
            ArrayTestUtils.printBitmap(a);
            a[row[i]][col[i]] = tmp;
            FloodFillRecursive.floodFillRecursive(copy, row[i], col[i]);
            System.out.println("\nAFTER flood fill:");
            ArrayTestUtils.printBitmap(copy);
        }
    }
}
