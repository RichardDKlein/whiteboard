package java.com.whiteboard;

import java.util.*;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using an iterative approach.
 */
public final class PowerSetIterative {
    private PowerSetIterative() {
    }

    /**
     * Compute the power set of a set, i.e. the set of all subsets of
     * that set, using an iterative approach. (Assume that the size of
     * the set does not exceed the number of bits in an integer.)
     *
     * We know that a set 's' with 'n' elements has (2 ** n) subsets.
     * So we just count from 0 to (2 ** n) - 1, using the bit pattern
     * in each count to select the elements of 's' that will form the
     * subset corresponding to that count.
     */
    public static <E> Set<Set<E>> powerSetIterative(Set<E> set) {
        Set<Set<E>> result = new HashSet<>();
        int numSubsets = (int)Math.pow(2, set.size());
        List<E> setList = new ArrayList<>(set);
        for (int i = 0; i < numSubsets; ++i) {
            Set<E> subset = new HashSet<>();
            for (int bitNum = 0; bitNum < set.size(); ++bitNum) {
                if (isBitSet(i, bitNum)) {
                    subset.add(setList.get(bitNum));
                }
            }
            result.add(subset);
        }
        return result;
    }

    private static boolean isBitSet(int n, int bit) {
        return (n & (1 << bit)) != 0;
    }
}
