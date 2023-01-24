package com.whiteboard;

import org.junit.Test;

import java.util.Arrays;

class SearchSortedAndRotatedArrayTest {
    @Test
    void searchSortedAndRotatedArrayTest() {
        System.out.println();
        System.out.println("Test SearchSortedAndRotatedArray:");
        System.out.println("=================================");
        int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; ++i) {
            int index = SearchSortedAndRotatedArray.searchSortedAndRotatedArray(a, a[i]);
            assert(index == i);
            System.out.println("target = " + a[i] + ", index = " + index);
        }

        int target = 999;
        int index = SearchSortedAndRotatedArray.searchSortedAndRotatedArray(a, target);
        assert(index == -1);
        System.out.println("target = " + target + ", index = " + index);
    }
}
