package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Merge two sorted arrays into a single sorted array.
 */
public class MergeTwoSortedArrays<T extends Comparable<T>> {
    ArrayList<T> a1_;
    ArrayList<T> a2_;

    public MergeTwoSortedArrays(ArrayList<T> a1, ArrayList<T> a2) {
        a1_ = a1;
        a2_ = a2;
    }

    public ArrayList<T> compute() {
        ArrayList<T> merged = new ArrayList<>();
        for (;;) {
            if (a1_.isEmpty()) {
                merged.addAll(a2_);
                break;
            }
            if (a2_.isEmpty()) {
                merged.addAll(a1_);
                break;
            }
            if (a1_.get(0).compareTo(a2_.get(0)) < 0) {
                merged.add(a1_.get(0));
                a1_.remove(0);
            } else {
                merged.add(a2_.get(0));
                a2_.remove(0);
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
            ArrayList<Integer> merged =
                new MergeTwoSortedArrays<Integer>(arrayList1, arrayList2).compute();
            System.out.println("merged = " + merged);
        }
    }
}
