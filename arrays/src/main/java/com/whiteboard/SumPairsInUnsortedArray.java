package com.whiteboard;

import com.sun.tools.javac.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * In an unsorted array, find pairs of array elements
 * that sum to a given value.
 */
public class SumPairsInUnsortedArray {
    /**
     * In an unsorted array, find pairs of array elements
     * that sum to a given value.
     *
     * Algorithm: Iterate thru the array, using a Set called
     * 'seen' to remember the elements we've already seen.
     *
     * For each element n, determine whether we've already
     * seen the element (sum - n). If so, then add the pair
     * (n, sum - n) to our result list.
     *
     * In any case, add the element n to our 'seen' Set.
     *
     * Running time: O(n)
     *
     * @param a The unsorted array to search for pairs.
     * @param sum The value to which each pair of elements should sum.
     */
    public static Set<Pair<Integer, Integer>>
    sumPairsInUnsortedArray(int[] a, int sum) {
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int n : a) {
            if (seen.contains(sum - n)) {
                pairs.add(new Pair<>(sum - n, n));
            }
            seen.add(n);
        }
        return pairs;
    }
}
