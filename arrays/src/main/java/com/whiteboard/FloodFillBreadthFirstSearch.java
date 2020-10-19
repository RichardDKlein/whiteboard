package com.whiteboard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the "flood fill" algorithm to fill a region
 * in a 2D array, using a Breadth-First Search (BFS)
 * approach.
 */
public final class FloodFillBreadthFirstSearch {
    private FloodFillBreadthFirstSearch() {
    }

    static class RowCol {
        int row;
        int col;

        RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Implement the "flood fill" algorithm to fill a region
     * in a 2D array, using a Breadth-First Search (BFS)
     * approach.
     *
     * The execution time is O(m * n) worst case, where m and
     * n are the number of rows and columns, respectively, in
     * the 2D array.
     *
     * @param a The 2D bitmap to be filled. An element of ' '
     *          denotes an empty pixel. An element of '@' denotes
     *          a filled pixel, which should also be interpreted
     *          as a boundary that the flood-fill algorithm is
     *          not allowed to cross. This bitmap is to be updated
     *          by the flood-fill algorithm.
     * @param seedRow The 0-based row index of the "seed" pixel,
     *                at which the flood fill is to start.
     * @param seedCol The 0-based column index of the seed pixel.
     */
    public static void floodFillBreadthFirstSearch(
            char[][] a, int seedRow, int seedCol) {

        int numRows = a.length;
        int numCols = a[0].length;

        Queue<RowCol> queue = new LinkedList<>();
        queue.add(new RowCol(seedRow, seedCol));

        while (!queue.isEmpty()) {
            RowCol rowCol = queue.poll();
            int row = rowCol.row;
            int col = rowCol.col;
            if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                continue;
            }
            if (a[row][col] == '@') {
                continue;
            }
            a[row][col] = '@';
            queue.add(new RowCol(row,col - 1));
            queue.add(new RowCol(row - 1, col));
            queue.add(new RowCol(row,col + 1));
            queue.add(new RowCol(row + 1, col));
        }
    }
}
