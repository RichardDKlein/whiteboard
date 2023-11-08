package com.whiteboard.java;

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
    public static void floodFillBreadthFirstSearch(char[][] a, int seedRow, int seedCol) {
        int numRows = a.length;
        int numCols = a[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] seed = {seedRow, seedCol};
        queue.add(seed);
        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int row = pixel[0];
            int col = pixel[1];
            if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                continue;
            }
            if (a[row][col] == '@') {
                continue;
            }
            a[row][col] = '@';
            int[] left = {row, col - 1};
            int[] up = {row - 1, col};
            int[] right = {row, col + 1};
            int[] down = {row + 1, col};
            queue.add(left);
            queue.add(up);
            queue.add(right);
            queue.add(down);
        }
    }
}
