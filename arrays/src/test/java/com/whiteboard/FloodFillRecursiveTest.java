package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class FloodFillRecursiveTest {
    @Test
    void floodFillRecursiveTest() {
        System.out.println();
        System.out.println("Test FloodFillRecursive:");
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

        int[] seedRow = {
                1,
                4,
                3,
                7,
                9
        };
        int[] seedCol = {
                1,
                4,
                12,
                8,
                10
        };

        char[][][] expected = {
                {
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', ' ', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', ' ', ' ', ' ', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',}
                },
                {
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', ' ', '@', ' ', '@', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', ' ', ' ', ' ', '@', ' ', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',}
                },
                {
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', '@', ' ', '@', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', ' ', ' ', ' ', '@', ' ', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',}
                },
                {
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', ' ', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', ' ', ' ', ' ', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', ' ', ' ', ' ', ' ', ' ', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',},
                        {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@',}
                },
                {
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', ' ', '@', ' ', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', ' ', ' ', '@', ' ', ' ', ' ', '@', '@', '@', ' ', ' ', ' ', ' ',},
                        {' ', ' ', '@', '@', '@', '@', ' ', ' ', '@', '@', '@', '@', '@', ' ', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', ' ', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', '@', '@', '@', '@', '@', '@', '@', '@', '@', ' ',},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',}
                }
        };

        int rows = a.length;
        int cols = a[0].length;
        char[][] copy = new char[rows][cols];
        for (int i = 0; i < seedRow.length; ++i) {
            System.out.println("\nBEFORE flood fill:");
            ArrayTestUtils.copyBitmap(a, copy);
            char tmp = a[seedRow[i]][seedCol[i]];
            a[seedRow[i]][seedCol[i]] = 'S';
            ArrayTestUtils.printBitmap(a);
            a[seedRow[i]][seedCol[i]] = tmp;
            FloodFillRecursive.floodFillRecursive(copy, seedRow[i], seedCol[i]);
            assert(Arrays.deepEquals(copy, expected[i]));
            System.out.println("\nAFTER flood fill:");
            ArrayTestUtils.printBitmap(copy);
        }
    }
}
