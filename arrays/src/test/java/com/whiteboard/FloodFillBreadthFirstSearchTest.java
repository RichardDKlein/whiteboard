package com.whiteboard;

import org.junit.jupiter.api.Test;

class FloodFillBreadthFirstSearchTest {
    @Test
    void floodFillBreadthFirstSearchTest() {
        System.out.println();
        System.out.println("Test FloodFillBreadthFirstSearch:");
        System.out.println("=================================");

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
            TestUtils.copyBitmap(a, copy);
            char tmp = a[row[i]][col[i]];
            a[row[i]][col[i]] = 'S';
            TestUtils.printBitmap(a);
            a[row[i]][col[i]] = tmp;
            FloodFillBreadthFirstSearch.floodFillBreadthFirstSearch(
                    copy, row[i], col[i]);
            System.out.println("\nAFTER flood fill:");
            TestUtils.printBitmap(copy);
        }
    }
}
