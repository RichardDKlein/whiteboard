package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

/**
 * In a sorted (in increasing order) array, find
 * pairs of array elements that sum to a given value.
 */
public final class SumPairsInSortedArray {
    private SumPairsInSortedArray() {}

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
    public static Set<Pair<Integer, Integer>>
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
                pairs.add(new Pair<>(a[left++], a[right--]));
            }
        }
        return pairs;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test SumPairsInSortedArray:");
        System.out.println("===========================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};
        System.out.println("sorted array = " + Arrays.toString(a));

        int sum = 12;
        Set<Pair<Integer, Integer>> pairs = sumPairsInSortedArray(a, sum);

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.getKey();
            int p2 = pair.getValue();
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}

