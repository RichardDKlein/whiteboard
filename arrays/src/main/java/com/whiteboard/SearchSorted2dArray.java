package com.whiteboard;

import java.util.Arrays;
import javafx.util.Pair;

/**
 * Search a 2D array in which all rows
 * and columns are sorted in ascending order.
 */
public class SearchSorted2dArray {
    /**
     * Search a 2D array in which all rows and columns
     * are sorted in ascending order.
     *
     * We use the following algorithm. Starting at the
     * lower-left corner of the array, we zig-zag our
     * way thru the 2D array until we either find the
     * target element, or reach the top or right edge
     * of the array. For each element on our zig-zag
     * path, we perform the following tests:
     *
     * If the current element is smaller than the target,
     * we can eliminate the current column (because all
     * unvisited elements in the current column will be
     * even smaller), so we move one column to the right.
     *
     * If the current element is larger than the target,
     * we can eliminate the current row (because all
     * unvisited elements in the current row will be
     * even larger), so we move up one row.
     *
     * If the current element is equal to the target,
     * then we are done!
     *
     * Running time = O(2n) = O(n), worst case.
     *
     * @param a The sorted 2D array to search.
     * @param target The element to search for.
     * @return A Pair containing the <row, column>
     *     indices of the element if found, or <-1, -1>
     *     if the element is not found.
     */
    public Pair<Integer, Integer>
    searchSorted2dArray(int[][] a, int target) {
        int rows = a.length;
        int cols = a[0].length;

        int bottom = rows - 1;
        int left = 0;
        int top = 0;
        int right = cols - 1;

        int row = bottom;
        int col = left;

        while (row >= top && col <= right) {
            if (a[row][col] < target) {
                ++col;
            } else if (a[row][col] > target) {
                --row;
            } else {
                return new Pair<>(row, col);
            }
        }
        return new Pair<>(-1, -1);
    }
}
