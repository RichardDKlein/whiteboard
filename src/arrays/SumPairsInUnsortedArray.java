package arrays;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * In an unsorted array, find pairs of array elements
 * that sum to a given value.
 */
public class SumPairsInUnsortedArray {
    private SumPairsInUnsortedArray() {}

    /**
     * @param a The sorted array to search for pairs.
     * @param sum The value to which each pair of elements should sum.
     */
    public static ArrayList<Pair<Integer, Integer>> find(int[] a, int sum) {
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int n : a) {
            if (seen.contains(sum - n)) {
                pairs.add(new Pair(n, sum - n));
            }
            seen.add(n);
        }
        return pairs;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test sumPairsInUnsortedArray():");
        System.out.println("===============================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};
        Integer aI[] = TestUtils.intArrayToIntegerArray(a);

        aI = new ShuffleArray<>(aI).shuffle();
        System.out.println("unsorted array = " + Arrays.toString(aI));

        a = TestUtils.IntegerArrayToIntArray(aI);
        int sum = 12;

        ArrayList<Pair<Integer, Integer>> pairs =
            SumPairsInUnsortedArray.find(a, sum);

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.fst;
            int p2 = pair.snd;
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
