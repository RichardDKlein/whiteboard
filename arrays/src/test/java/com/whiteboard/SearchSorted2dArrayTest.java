package com.whiteboard;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import com.whiteboard.SearchSorted2dArray.RowCol;

class SearchSorted2dArrayTest {
    @Test
    void searchSorted2dArrayTest() {
        System.out.println();
        System.out.println("Test SearchSorted2dArray:");
        System.out.println("=========================");

        int a[][] = {
                { 15, 20, 40, 60, 63 },
                { 25, 35, 65, 70, 74 },
                { 30, 55, 75, 80, 82 },
                { 45, 61, 85, 90, 99 }
        };

        for (int row = 0; row < a.length; ++row) {
            System.out.println(Arrays.toString(a[row]));
        }

        for (int row = 0; row < a.length; ++row) {
            for (int col = 0; col < a[0].length; ++col) {
                int target = a[row][col];
                RowCol loc = SearchSorted2dArray.searchSorted2dArray(a, target);
                assert(loc.row == row);
                assert(loc.col == col);
                System.out.println("target = " + target + ", row = " +
                        loc.row + ", col = " + loc.col);
            }
        }

        int target = 64;
        RowCol loc = SearchSorted2dArray.searchSorted2dArray(a, target);
        assert(loc.row == -1);
        assert(loc.col == -1);
        System.out.println("target = " + target + ", row = " +
                loc.row + ", col = " + loc.col);
    }
}
