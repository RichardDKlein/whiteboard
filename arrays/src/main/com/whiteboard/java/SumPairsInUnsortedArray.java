package com.whiteboard.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * In an unsorted array, find pairs of array elements
 * that sum to a given value.
 */
public final class SumPairsInUnsortedArray {
    private SumPairsInUnsortedArray() {
    }

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
     * @param sum The value to which each pair of elements
     *            should sum.
     * @return A set containing all the pairs of elements
     * that sum to the desired value. Each pair is represented
     * by a set containing two integers, except in the case
     * where both elements of the pair are the same integer.
     * In that case, the pair is represented by a set containing
     * that single integer.
     */
    public static Set<Set<Integer>> sumPairsInUnsortedArray(int[] a, int sum) {
        Set<Set<Integer>> result = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int n : a) {
            if (seen.contains(sum - n)) {
                Set<Integer> pair = new HashSet<>();
                pair.add(n);
                pair.add(sum -n);
                result.add(pair);
            }
            seen.add(n);
        }
        return result;
    }
}
