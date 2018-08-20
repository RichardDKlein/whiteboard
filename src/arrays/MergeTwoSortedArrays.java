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
     * If one of the two input arrays becomes empty,
     * then we simply append the remaining input array
     * to the output array.
     *
     * Running time is O(n).
     *
     * @param a1 One of the sorted arrays.
     * @param a2 The other sorted array.
     * @return The merged, sorted array.
     */
    public static List<Integer>
    merge(List<Integer> a1, List<Integer> a2) {
        List<Integer> merged = new ArrayList<>();
        for (;;) {
            if (a1.isEmpty()) {
                merged.addAll(a2);
                break;
            }
            if (a2.isEmpty()) {
                merged.addAll(a1);
                break;
            }
            if (a1.get(0).compareTo(a2.get(0)) < 0) {
                merged.add(a1.get(0));
                a1.remove(0);
            } else {
                merged.add(a2.get(0));
                a2.remove(0);
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
            List<Integer> merged = MergeTwoSortedArrays.merge(arrayList1, arrayList2);
            System.out.println("merged = " + merged);
        }
    }
}
