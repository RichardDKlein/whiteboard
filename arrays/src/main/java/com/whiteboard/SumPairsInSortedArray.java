package com.whiteboard;

import com.sun.tools.javac.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * In a sorted (in increasing order) array, find
 * pairs of array elements that sum to a given value.
 */
public class SumPairsInSortedArray {
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
     * @param sum The value to which each pair of elements should sum.
     */
    public Set<Pair<Integer, Integer>>
    sumPairsInSortedArray(int[] a, int sum) {
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] < sum) {
                ++left;
            } else if (a[left] + a[right] > sum) {
                --right;
            } else {
                pairs.add(new Pair<>(a[left], a[right]));
                ++left;
                --right;
            }
        }
        return pairs;
    }
}
