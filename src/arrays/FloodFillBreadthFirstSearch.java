package arrays;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the "flood fill" algorithm to fill a region
 * in a 2D array, using a Breadth-First Search (BFS)
 * approach.
 */
public final class FloodFillBreadthFirstSearch {
    private FloodFillBreadthFirstSearch() {}

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

    public static void test() {
        System.out.println();
        System.out.println("Test FloodFillBreadthFirstSearch:");
        System.out.println("=================================");

        char[][] a = {
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ',' ',' ',' ','@','@','@','@','@','@','@',' ',},
                {' ',' ','@','@','@','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ','@','@','@','@','@','@','@',' ',},
                {' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
                {' ',' ','@',' ',' ','@',' ',' ',' ',' ','@',' ',' ',' ',' ',' ',},
                {' ',' ','@',' ',' ','@',' ',' ',' ','@',' ','@',' ',' ',' ',' ',},
                {' ',' ','@','@','@','@',' ',' ','@',' ',' ',' ','@',' ',' ',' ',},
                {' ',' ',' ',' ',' ',' ',' ','@',' ',' ',' ',' ',' ','@',' ',' ',},
                {' ',' ',' ',' ',' ',' ','@','@','@','@','@','@','@','@','@',' ',},
                {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',}
        };

        int[] row = {
                1,
                4,
                3,
                7,
                9
        };
        int[] col = {
                1,
                4,
                12,
                8,
                10
        };
        int rows = a.length;
        int cols = a[0].length;
        char[][] copy = new char[rows][cols];
        for (int i = 0; i < row.length; ++i) {
            System.out.println("\nBEFORE flood fill:");
            TestUtils.copyBitmap(a, copy);
            char tmp = a[row[i]][col[i]];
            a[row[i]][col[i]] = 'S';
            TestUtils.printBitmap(a);
            a[row[i]][col[i]] = tmp;
            floodFillBreadthFirstSearch(copy, row[i], col[i]);
            System.out.println("\nAFTER flood fill:");
            TestUtils.printBitmap(copy);
        }
    }
}
