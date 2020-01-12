package arrays;

/**
 * Implement the "flood fill" algorithm to fill a region
 * in a 2D array, using a recursive approach.
 */
public final class FloodFillRecursive {
    private FloodFillRecursive() {}

    /**
     * Implement the "flood fill" algorithm to fill a region
     * in a 2D bitmap, using a recursive approach.
     *
     * The execution time is O(m * n) worst case, where m and
     * n are the number of rows and columns, respectively, in
     * the 2D array.
     *
     * However, the space requirements (for the call stack)
     * are also O(m * n), due to the recursive nature of the
     * algorithm. Yuck.
     *
     * For an algorithm with more modest space requirements,
     * see the FloodFillBreadthFirstSearch class.
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
    public static void floodFillRecursive(
            char[][] a, int seedRow, int seedCol) {
        int rows = a.length;
        int cols = a[0].length;
        if (seedRow < 0 || seedCol < 0 || seedRow >= rows || seedCol >= cols) {
            return;
        }
        if (a[seedRow][seedCol] == '@') {
            return;
        }
        a[seedRow][seedCol] = '@';
        floodFillRecursive(a, seedRow, seedCol - 1);
        floodFillRecursive(a, seedRow - 1, seedCol);
        floodFillRecursive(a, seedRow, seedCol + 1);
        floodFillRecursive(a, seedRow + 1, seedCol);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test floodFillRecursive:");
        System.out.println("========================");

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
            floodFillRecursive(copy, row[i], col[i]);
            System.out.println("\nAFTER flood fill:");
            TestUtils.printBitmap(copy);
        }
    }
}
