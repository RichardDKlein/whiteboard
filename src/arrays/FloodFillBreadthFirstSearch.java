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
     * @param x The x-coordinate of the "seed" pixel, at which
     *          the flood fill is to start.
     * @param y The y-coordinate of the seed pixel.
     */
    public static void floodFillBreadthFirstSearch(
            char[][] a, int x, int y) {
        int rows = a.length;
        int cols = a[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(x, y));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> coords = queue.poll();
            int x1 = coords.getKey();
            int y1 = coords.getValue();
            if (x1 < 0 || y1 < 0 || x1 >= cols || y1 >= rows) {
                continue;
            }
            if (a[y1][x1] == ' ') {
                a[y1][x1] = '@';
                queue.add(new Pair<>(x1 - 1, y1));
                queue.add(new Pair<>(x1, y1 - 1));
                queue.add(new Pair<>(x1 + 1, y1));
                queue.add(new Pair<>(x1, y1 + 1));
            }
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

        int[] x = {
                1,
                4,
                12,
                8,
                10
        };
        int[] y = {
                1,
                4,
                3,
                7,
                9
        };
        int rows = a.length;
        int cols = a[0].length;
        char[][] copy = new char[rows][cols];
        for (int i = 0; i < x.length; ++i) {
            System.out.println("\nBEFORE flood fill:");
            TestUtils.copyBitmap(a, copy);
            char tmp = a[y[i]][x[i]];
            a[y[i]][x[i]] = 'S';
            TestUtils.printBitmap(a);
            a[y[i]][x[i]] = tmp;
            floodFillBreadthFirstSearch(copy, x[i], y[i]);
            System.out.println("\nAFTER flood fill:");
            TestUtils.printBitmap(copy);
        }
    }
}
