package java.com.whiteboard;

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
     * @param sum The value to which each pair of elements should sum.
     */
    public static Set<UnorderedPair> sumPairsInSortedArray(int[] a, int sum) {
        Set<UnorderedPair> result = new HashSet<>();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] < sum) {
                ++left;
            } else if (a[left] + a[right] > sum) {
                --right;
            } else {
                result.add(new UnorderedPair(a[left], a[right]));
                ++left;
                --right;
            }
        }
        return result;
    }
}
