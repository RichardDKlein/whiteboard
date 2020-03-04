/**
 * Traverse a 2D array in a spiral pattern, starting at
 * the upper-left element and spiralling in the clockwise
 * direction.
 */

package com.whiteboard;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse2dArray {
    /**
     * Traverse a 2D array, NOT NECESSARILY SQUARE, in a spiral
     * pattern, starting at the upper-left element, and spiralling
     * in the clockwise direction.
     *
     * We shall use a straighforward iterative algorithm that
     * traverses each "shell", or layer, of the array, starting
     * with the outermost shell and proceeding inward.
     *
     * Execution time is O(n), where n is the number of elements
     * in the array.
     *
     * @param a The 2D array that is to be traversed in a spiral
     *          pattern.
     * @return A list containing the array elements in spiral order.
     */
    public List<Integer> spiralTraverse2dArray(int[][] a) {
        List<Integer> spiral = new ArrayList<>();
        int rowTop, rowBottom, colLeft, colRight;
        for (rowTop = 0, rowBottom = a.length - 1,
                     colLeft = 0, colRight = a[0].length - 1;
             rowTop <= rowBottom && colLeft <= colRight;
             ++rowTop, --rowBottom, ++colLeft, --colRight) {

            List<Integer> shell = spiralTraverseShell(
                    a, rowTop, rowBottom, colLeft, colRight);
            spiral.addAll(shell);
        }
        return spiral;
    }

    private List<Integer> spiralTraverseShell(int[][]a,
            int rowTop, int rowBottom, int colLeft, int colRight) {

        List<Integer> shell = new ArrayList<>();
        // degenerate case where shell is 1-dimensional
        if (rowTop == rowBottom) {
            for (int col = colLeft; col <= colRight; ++col) {
                shell.add(a[rowTop][col]);
            }
            return shell;
        }
        if (colLeft == colRight) {
            for (int row = rowTop; row <= rowBottom; ++row) {
                shell.add(a[row][colLeft]);
            }
            return shell;
        }
        // top row
        for (int col = colLeft; col < colRight; ++col) {
            shell.add(a[rowTop][col]);
        }
        // right column
        for (int row = rowTop; row < rowBottom; ++row) {
            shell.add(a[row][colRight]);
        }
        // bottom row
        for (int col = colRight; col > colLeft; --col) {
            shell.add(a[rowBottom][col]);
        }
        // left column
        for (int row = rowBottom; row > rowTop; --row) {
            shell.add(a[row][colLeft]);
        }
        return shell;
    }
}
