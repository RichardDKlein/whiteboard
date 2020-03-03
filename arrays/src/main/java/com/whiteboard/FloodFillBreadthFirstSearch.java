package com.whiteboard;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

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

        Queue<Pair<Integer, Integer>> seedQueue = new LinkedList<>();
        int numRows = a.length;
        int numCols = a[0].length;
        seedQueue.add(new Pair<>(seedRow, seedCol));
        while (!seedQueue.isEmpty()) {
            Pair<Integer, Integer> seed = seedQueue.poll();
            int row = seed.getKey();
            int col = seed.getValue();
            if (row < 0 || col < 0 || row >= numRows || col >= numCols) {
                continue;
            }
            if (a[row][col] == '@') {
                continue;
            }
            a[row][col] = '@';
            seedQueue.add(new Pair<>(row, col - 1));
            seedQueue.add(new Pair<>(row - 1, col));
            seedQueue.add(new Pair<>(row, col + 1));
            seedQueue.add(new Pair<>(row + 1, col));
        }
    }
}
