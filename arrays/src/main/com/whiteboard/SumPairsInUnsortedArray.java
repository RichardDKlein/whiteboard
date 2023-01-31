package com.whiteboard;

import java.util.HashSet;
import java.util.Set;

/**
 * In an unsorted array, find pairs of array elements
 * that sum to a given value.
 */
public final class SumPairsInUnsortedArray {
    private SumPairsInUnsortedArray() {
    }

    static class UnorderedPair {
        int first;
        int second;

        UnorderedPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof UnorderedPair other)) {
                return false;
            }
            return (this.first == other.first && this.second == other.second) ||
                    (this.first == other.second && this.second == other.first);
        }

        @Override
        public int hashCode() {
            return first + second;
        }
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
     * @param sum The value to which each pair of elements should sum.
     */
    public static Set<UnorderedPair> sumPairsInUnsortedArray(int[] a, int sum) {
        Set<UnorderedPair> result = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int n : a) {
            if (seen.contains(sum - n)) {
                result.add(new UnorderedPair(n, sum - n));
            }
            seen.add(n);
        }
        return result;
    }
}
