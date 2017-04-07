package arrays;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;

/**
 * Search a 2D array in which all rows
 * and columns are sorted in ascending order.
 */
public class SearchSorted2dArray {
    private int[][] a;
    private int target;

    public SearchSorted2dArray(int[][] a, int target) {
        this.a = a;
        this.target = target;
    }

    /**
     * @return The (row, col) of target
     * [or (-1, -1) if not found].
     */
    public Pair<Integer, Integer> compute() {
        int rows = a.length;
        int cols = a[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        int row = bottom;
        int col = left;
        while (row >= top && col <= right) {
            if (a[row][col] < target) {
                ++col;
            } else if (a[row][col] > target) {
                --row;
            } else {
                return new Pair(row, col);
            }
        }
        return new Pair(-1, -1);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test searchSorted2dArray():");
        System.out.println("===========================");

        int a[][] = {
            { 15, 20, 40, 60, 63 },
            { 25, 35, 65, 70, 74 },
            { 30, 55, 75, 80, 82 },
            { 45, 61, 85, 90, 99 }
        };

        for (int row = 0; row < a.length; ++row) {
            System.out.println(Arrays.toString(a[row]));
        }

        for (int row = 0; row < a.length; ++row) {
            for (int col = 0; col < a[0].length; ++col) {
                int target = a[row][col];
                Pair<Integer, Integer> loc =
                    new SearchSorted2dArray(a, target).compute();
                System.out.println("target = " + target + ", row = " +
                    loc.fst + ", col = " + loc.snd);
            }
        }

        int target = 16;
        Pair<Integer, Integer> loc =
            new SearchSorted2dArray(a, target).compute();
        System.out.println("target = " + target + ", row = " +
            loc.fst + ", col = " + loc.snd);
    }
}
