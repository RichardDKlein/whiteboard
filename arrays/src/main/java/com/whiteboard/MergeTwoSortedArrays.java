package com.whiteboard;

import java.util.Arrays;

/**
 * Merge two sorted arrays into a single sorted array.
 */
public class MergeTwoSortedArrays {
    /**
     * Merge two sorted arrays into a single sorted array.
     *
     * The algorithm we shall use is the "merge" part of the
     * merge sort. We simply compare the two top elements of
     * the two sorted input arrays, and pick the smaller one
     * to append to the output array.
     *
     * If one of the two input arrays is completely merged,
     * then we simply append the remaining input array to the
     * output array.
     *
     * Running time is O(n).
     *
     * @param a1 One of the sorted arrays.
     * @param a2 The other sorted array.
     * @return The merged, sorted array.
     */
    public int[] mergeTwoSortedArrays(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];
        int iMerged, i1, i2;
        iMerged = i1 = i2 = 0;
        while (iMerged < merged.length) {
            if (i1 >= a1.length) {
                while (i2 < a2.length) {
                    merged[iMerged++] = a2[i2++];
                }
            } else if (i2 >= a2.length) {
                while (i1 < a1.length) {
                    merged[iMerged++] = a1[i1++];
                }
            } else {
                merged[iMerged++] = a1[i1] < a2[i2] ? a1[i1++] : a2[i2++];
            }
        }
        return merged;
    }
}
