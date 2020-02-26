package com.whiteboard;

import java.util.*;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using an iterative approach.
 */
public class PowerSetIterative<E> {
    /**
     * Compute the power set of a set, i.e. the set of all subsets of
     * that set, using an iterative approach.
     *
     * We know that a set 's' with 'n' elements has (2 ** n) subsets.
     * So we just count from 0 to (2 ** n) - 1, using the bit pattern
     * in each count to select the elements of 's' that will form the
     * subset corresponding to that count.
     */
    public Set<Set<E>> powerSetIterative(Set<E> set) {
        Set<Set<E>> powerSet = new HashSet<>();
        List<E> elements = new ArrayList<>(set);
        int numSubsets = (int)Math.pow(2, set.size());
        for (int i = 0; i < numSubsets; ++i) {
            Set<E> subset = new HashSet<>();
            for (int bit = 0; bit < set.size(); ++bit) {
                if ((i & (1 << bit)) != 0) {
                    subset.add(elements.get(bit));
                }
            }
            powerSet.add(subset);
        }
        return powerSet;
    }
}
