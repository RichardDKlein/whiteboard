package arrays;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * In a sorted array, find pairs of array elements
 * that sum to a given value.
 */
public class SumPairsInSortedArray {
    private int[] a_;
    private int sum_;

    /**
     * @brief Constructor.
     *
     * @param a The sorted array to search for pairs.
     * @param sum The value to which each pair of elements should sum.
     */
    public SumPairsInSortedArray(int[] a, int sum) {
        a_ = a;
        sum_ = sum;
    }

    public ArrayList<Pair<Integer, Integer>> compute() {
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int left = 0;
        int right = a_.length - 1;
        while (left < right) {
            if (a_[left] + a_[right] < sum_) {
                ++left;
            } else if (a_[left] + a_[right] > sum_) {
                --right;
            } else {
                pairs.add(new Pair(a_[left++], a_[right--]));
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
        ArrayList<Pair<Integer, Integer>> pairs =
            new SumPairsInSortedArray(a, sum).compute();

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.fst;
            int p2 = pair.snd;
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
