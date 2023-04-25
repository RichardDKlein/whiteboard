package com.whiteboard.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * In a sorted (in increasing order) array, find
 * pairs of array elements that sum to a given value.
 */
public final class SumPairsInSortedArray {
    private SumPairsInSortedArray() {
    }

    /**
     * In a sorted (in increasing order) array, find
     * pairs of array elements that sum to a given value.
     *
     * Algorithm: Start at both ends of the array, and
     * work toward the middle. (This works only if the
     * array is sorted.)
     *
     * Running time: O(n)
     *
     * @param a The sorted array to search for pairs.
     * @param sum The value to which each pair of elements
     *            should sum.
     * @return A set containing all the pairs of elements
     * that sum to the desired value. Each pair is represented
     * by a set containing two integers, except in the case
     * where both elements of the pair are the same integer.
     * In that case, the pair is represented by a set containing
     * that single integer.
     */
    public static Set<Set<Integer>> sumPairsInSortedArray(int[] a, int sum) {
        Set<Set<Integer>> result = new HashSet<>();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] < sum) {
                ++left;
            } else if (a[left] + a[right] > sum) {
                --right;
            } else {
                result.add(new HashSet<>(Arrays.asList(a[left], a[right])));
                ++left;
                --right;
            }
        }
        return result;
    }
}
