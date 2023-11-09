package com.whiteboard.java;

import java.util.ArrayList;
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
        List<int[]> halves = splitArrayIntoHalves(a);
        int[] left = halves.get(0);
        int[] right = halves.get(1);
        int[] leftSorted = mergeSort(left);
        int[] rightSorted = mergeSort(right);
        return mergeTwoSortedArrays(leftSorted, rightSorted);
    }

    private static List<int[]> splitArrayIntoHalves(int[] a) {
        List<int[]> result = new ArrayList<>();
        int iLeftEnd;
        if (a.length % 2 == 0) {
            iLeftEnd = a.length / 2 - 1;
        } else {
            iLeftEnd = a.length / 2;
        }
        int leftLen = iLeftEnd - 0 + 1;
        int rightLen = (a.length - 1) - (iLeftEnd + 1) + 1;
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];
        for (int iSrc = 0, iDest = 0; iSrc <= iLeftEnd; ++iSrc, ++iDest) {
            left[iDest] = a[iSrc];
        }
        for (int iSrc = iLeftEnd + 1, iDest = 0; iSrc < a.length; ++iSrc, ++iDest) {
            right[iDest] = a[iSrc];
        }
        result.add(left);
        result.add(right);
        return result;
    }


    private static int[] mergeTwoSortedArrays(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];
        int i1, i2, iMerged;
        i1 = i2 = iMerged = 0;
        while (iMerged < merged.length) {
            // if a1 is fully merged, just append the remaining a2 elements
            if (i1 >= a1.length) {
                while (i2 < a2.length) {
                    merged[iMerged++] = a2[i2++];
                }
            }
            // if a2 is fully merged, just append the remaining a1 elements
            else if (i2 >= a2.length) {
                while (i1 < a1.length) {
                    merged[iMerged++] = a1[i1++];
                }
            } else {
                merged[iMerged++] = (a1[i1] <= a2[i2]) ? a1[i1++] : a2[i2++];
            }
        }
        return merged;
    }
}
