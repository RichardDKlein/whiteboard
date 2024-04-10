package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sort an array using the `merge sort` algorithm.
 */
public final class MergeSort {
    private MergeSort() {
    }

    /**
     * Sort an array using the `merge sort` algorithm.
     *
     * Running time is O(n * log(n)).
     *
     * @param a The array to be sorted.
     * @return The sorted array.
     */
    public static int[] mergeSort(int[] a) {
        // base case
        if (a.length == 1) {
            return a;
        }
        int[][] halves = splitArrayIntoHalves(a);
        int[] leftSorted = mergeSort(halves[0]);
        int[] rightSorted = mergeSort(halves[1]);
        return mergeTwoSortedArrays(leftSorted, rightSorted);
    }

    private static int[][] splitArrayIntoHalves(int[] a) {
        int halfLength = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, halfLength);
        int[] right = Arrays.copyOfRange(a, halfLength, a.length);
        return new int[][] {left, right};
    }

    private static int[] mergeTwoSortedArrays(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];
        int i1, i2, iMerged;
        i1 = i2 = iMerged = 0;
        while (i1 < a1.length && i2 < a2.length) {
            merged[iMerged++] = (a1[i1] <= a2[i2]) ? a1[i1++] : a2[i2++];
        }
        while (i1 < a1.length) {
            merged[iMerged++] = a1[i1++];
        }
        while (i2 < a2.length) {
            merged[iMerged++] = a2[i2++];
        }
        return merged;
    }
}
