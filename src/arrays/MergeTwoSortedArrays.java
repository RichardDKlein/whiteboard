package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge two sorted arrays into a single sorted array.
 */
public class MergeTwoSortedArrays {
    private MergeTwoSortedArrays() {}

    /**
     * Merge two sorted arrays into a single sorted
     * array.
     *
     * Algorithm: The "merge" part of the merge sort.
     * We simply compare the two top elements of the
     * two sorted input arrays, and pick the smaller
     * one to append to the output array.
     *
     * If one of the two input arrays is completely
     * merged, then we simply append the remaining
     * input array to the output array.
     *
     * Running time is O(n).
     *
     * @param a1 One of the sorted arrays.
     * @param a2 The other sorted array.
     * @return The merged, sorted array.
     */
    public static int[] mergeTwoSortedArrays(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];
        int i1 = 0;
        int i2 = 0;
        int iMerged = 0;
        for (;;) {
            if (i1 >= a1.length) {
                while (i2 < a2.length) {
                    merged[iMerged++] = a2[i2++];
                }
                break;
            }
            if (i2 >= a2.length) {
                while (i1 < a1.length) {
                    merged[iMerged++] = a1[i1++];
                }
                break;
            }
            if (a1[i1] < a2[i2]) {
                merged[iMerged++] = a1[i1++];
            } else {
                merged[iMerged++] = a2[i2++];
            }
        }
        return merged;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test mergeTwoSortedArrays():");
        System.out.println("============================");

        int[][] a1 = {
            {1, 3, 5, 7, 9},
            {1, 3, 5, 7, 9},
            {1, 3, 5, 7, 9, 11, 13, 15},
            {1, 2, 3, 4, 5}
        };

        int[][] a2 = {
            {2, 4, 6, 8, 10},
            {2, 4, 6, 8, 10, 12, 14, 16},
            {2, 4, 6, 8, 10},
            {1, 2, 3, 4, 5}
        };

        for (int i = 0; i < a1.length; ++i) {
            System.out.println("a1 = " + Arrays.toString(a1[i]));
            System.out.println("a2 = " + Arrays.toString(a2[i]));
            ArrayList<Integer> arrayList1 = TestUtils.intArrayToArrayList(a1[i]);
            ArrayList<Integer> arrayList2 = TestUtils.intArrayToArrayList(a2[i]);
            int[] merged = MergeTwoSortedArrays.mergeTwoSortedArrays(a1[i], a2[i]);
            System.out.println("merged = " + Arrays.toString(merged));
        }
    }
}
