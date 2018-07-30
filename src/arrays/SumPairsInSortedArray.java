package arrays;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a sorted (in increasing order) array, find
 * pairs of array elements that sum to a given value.
 *
 * Algorithm: Start at both ends of the array, and
 * work toward the middle. (This works only if the
 * array is sorted.)
 *
 * Running time: O(n)
 */
public class SumPairsInSortedArray {
    private SumPairsInSortedArray() {}

    /**
     * @param a The sorted array to search for pairs.
     * @param sum The value to which each pair of elements should sum.
     */
    public static List<Pair<Integer, Integer>>
    findPairs(int[] a, int sum) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] < sum) {
                ++left;
            } else if (a[left] + a[right] > sum) {
                --right;
            } else {
                pairs.add(new Pair(a[left++], a[right--]));
            }
        }
        return pairs;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test sumPairsInSortedArray():");
        System.out.println("=============================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};
        System.out.println("sorted array = " + Arrays.toString(a));

        int sum = 12;
        List<Pair<Integer, Integer>> pairs =
            SumPairsInSortedArray.findPairs(a, sum);

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.fst;
            int p2 = pair.snd;
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
