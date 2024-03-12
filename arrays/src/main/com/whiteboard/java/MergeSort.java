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
        int[] result = new int[a.length];
        // base case
        if (a.length == 1) {
            result[0] = a[0];
            return result;
        }
        // recursive step
        int[][] halves = splitArrayIntoHalves(a);
        int[] leftSorted = mergeSort(halves[0]);
        int[] rightSorted = mergeSort(halves[1]);
        return mergeTwoSortedArrays(leftSorted, rightSorted);
    }

    private static int[][] splitArrayIntoHalves(int[] a) {
        int[][] result = new int[2][];
        int size1 = a.length / 2;
        result[0] = Arrays.copyOfRange(a, 0, size1);
        result[1] = Arrays.copyOfRange(a, size1, a.length);
        return result;
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
