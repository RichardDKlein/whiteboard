/**
 * Traverse a 2D array in a spiral pattern, starting at
 * the upper-left element and spiralling in the clockwise
 * direction.
 */

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SpiralTraverse2dArray {
    private SpiralTraverse2dArray() {}

    /**
     * Traverse a 2D array in a spiral pattern, starting at
     * the upper-left element and spiralling in the clockwise
     * direction.
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
    public static List<Integer>
    spiralTraverse2dArray(int[][] a) {
        List<Integer> spiral = new ArrayList<>();
        int rowTop, rowBottom;
        for (rowTop = 0, rowBottom = a.length - 1; rowTop <= rowBottom; ++rowTop, --rowBottom) {
            spiral.addAll(spiralTraverseShell(a, rowTop, rowBottom));
        }
        return spiral;
    }

    private static List<Integer> spiralTraverseShell(int[][]a, int rowTop, int rowBottom) {
        List<Integer> shell = new ArrayList<>();
        int colLeft = rowTop;
        int colRight = rowBottom;
        // degenerate case where shell is a single element
        if (rowTop == rowBottom) {
            shell.add(a[rowTop][colLeft]);
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

    public static void test() {
        System.out.println();
        System.out.println("Test SpiralTraverse2dArray:");
        System.out.println("===========================");

        int[][][] a = {
                {
                        {1}
                },
                {
                        {1, 2},
                        {3, 4}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        { 1,  2,  3,  4},
                        { 5,  6,  7,  8},
                        { 9, 10, 11, 12},
                        {13, 14, 15, 16}
                },
                {
                        { 1,  2,  3,  4,  5},
                        { 6,  7,  8,  9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}
                }
        };
        for (int i = 0; i < a.length; ++i) {
            System.out.println("\nArray:");
            int rows = a[i].length;
            for (int row = 0; row < rows; ++row) {
                System.out.println(Arrays.toString(a[i][row]));
            }
            List<Integer> spiral = spiralTraverse2dArray(a[i]);
            System.out.println("\nSpiral Traversal:");
            System.out.println(spiral.toString());
        }
    }
}
