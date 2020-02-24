package com.whiteboard;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SearchSortedAndRotatedArrayTest {
    @Test
    void searchSortedAndRotatedArray() {
        System.out.println();
        System.out.println("Test SearchSortedAndRotatedArray:");
        System.out.println("=================================");
        int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(Arrays.toString(a));

        SearchSortedAndRotatedArray instance = new SearchSortedAndRotatedArray();

        for (int target : a) {
            int index = instance.searchSortedAndRotatedArray(a, target);
            System.out.println("target = " + target + ", index = " + index);
        }

        int target = 999;
        int index = instance.searchSortedAndRotatedArray(a, target);
        System.out.println("target = " + target + ", index = " + index);
    }
}
