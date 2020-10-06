package com.whiteboard;

import java.util.HashSet;
import java.util.Set;

/**
 * In a sorted (in increasing order) array, find
 * pairs of array elements that sum to a given value.
 */
public final class SumPairsInSortedArray {
    private SumPairsInSortedArray() {
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        // Following methods are needed only for the unit test.
        @Override
        public int hashCode() {
            return (first << 15) + second;
        }
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) other;
            return this.first == pair.first && this.second == pair.second;
        }
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
     * @param sum The value to which each pair of elements should sum.
     */
    public static Set<Pair> sumPairsInSortedArray(int[] a, int sum) {
        Set<Pair> pairs = new HashSet<>();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] < sum) {
                ++left;
            } else if (a[left] + a[right] > sum) {
                --right;
            } else {
                pairs.add(new Pair(a[left], a[right]));
                ++left;
                --right;
            }
        }
        return pairs;
    }
}
