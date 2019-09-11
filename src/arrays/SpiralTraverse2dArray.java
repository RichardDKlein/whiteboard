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
        int rows = a.length;
        for (int topRow = 0, bottomRow = rows - 1;
             topRow <= bottomRow;
             ++topRow, --bottomRow) {

            List<Integer> shell = spiralTraverseHelper(a, topRow, bottomRow);
            spiral.addAll(shell);
        }
        return spiral;
    }

    /**
     * Traverse one shell of a 2D array in a clockwise spiral
     * pattern, starting at the specified element.
     *
     * @param a The array of interest.
     * @param topRow The 0-based top row of the shell of interest.
     * @param bottomRow The 0-based bottom row of the shell of interest.
     *
     * @return A list containing the array shell's elements in
     * spiral order.
     */
    private static List<Integer>
    spiralTraverseHelper(int[][] a, int topRow, int bottomRow) {
        List<Integer> spiral = new ArrayList<>();
        // degenerate case where shell is a single element
        if (topRow == bottomRow) {
            spiral.add(a[topRow][topRow]);
            return spiral;
        }
        int leftCol = topRow;
        int rightCol = bottomRow;
        // top row
        for (int col = leftCol; col < rightCol; ++col) {
            spiral.add(a[topRow][col]);
        }
        // right column
        for (int row = topRow; row < bottomRow; ++row) {
            spiral.add(a[row][rightCol]);
        }
        // bottom row
        for (int col = rightCol; col > leftCol; --col) {
            spiral.add(a[bottomRow][col]);
        }
        // left column
        for (int row = bottomRow; row > topRow; --row) {
            spiral.add(a[row][leftCol]);
        }
        return spiral;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test spiralTraverse2dArray():");
        System.out.println("=============================");

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
