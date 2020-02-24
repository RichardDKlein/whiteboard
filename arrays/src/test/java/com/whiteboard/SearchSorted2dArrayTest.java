package com.whiteboard;

import java.util.Arrays;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

class SearchSorted2dArrayTest {

    @Test
    void searchSorted2dArray() {
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

        SearchSorted2dArray instance = new SearchSorted2dArray();

        for (int row = 0; row < a.length; ++row) {
            for (int col = 0; col < a[0].length; ++col) {
                int target = a[row][col];
                Pair<Integer, Integer> loc =
                        instance.searchSorted2dArray(a, target);
                System.out.println("target = " + target + ", row = " +
                        loc.getKey() + ", col = " + loc.getValue());
            }
        }

        int target = 64;
        Pair<Integer, Integer> loc =
                instance.searchSorted2dArray(a, target);
        System.out.println("target = " + target + ", row = " +
                loc.getKey() + ", col = " + loc.getValue());
    }
}
