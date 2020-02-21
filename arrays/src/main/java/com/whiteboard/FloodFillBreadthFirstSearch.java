package com.whiteboard;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the "flood fill" algorithm to fill a region
 * in a 2D array, using a Breadth-First Search (BFS)
 * approach.
 */
public class FloodFillBreadthFirstSearch {
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
    public void floodFillBreadthFirstSearch(
            char[][] a, int seedRow, int seedCol) {
        int rows = a.length;
        int cols = a[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(seedRow, seedCol));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> coords = queue.poll();
            int row = coords.getKey();
            int col = coords.getValue();
            if (row < 0 || col < 0 || row >= rows || col >= cols) {
                continue;
            }
            if (a[row][col] == '@') {
                continue;
            }
            a[row][col] = '@';
            queue.add(new Pair<>(row, col - 1));
            queue.add(new Pair<>(row - 1, col));
            queue.add(new Pair<>(row, col + 1));
            queue.add(new Pair<>(row + 1, col));
        }
    }
}
