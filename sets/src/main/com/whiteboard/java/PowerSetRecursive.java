package com.whiteboard.java;

import java.util.*;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using a recursive approach.
 */
public final class PowerSetRecursive {
    private PowerSetRecursive() {
    }

    public static <E> Set<Set<E>> powerSetRecursive(Set<E> set) {
        Set<Set<E>> result = new HashSet<>();
        // base case
        if (set.isEmpty()) {
            Set<E> emptySet = new HashSet<>();
            result.add(emptySet);
            return result;
        }
        // recursive step
        Iterator<E> iterator = set.iterator();
        E firstElement = iterator.next();
        iterator.remove();
        Set<Set<E>> remainderPowerSet = powerSetRecursive(set);
        for (Set<E> remainderSubset : remainderPowerSet) {
            result.add(remainderSubset);
            Set<E> remainderSubsetCopy = new HashSet<>(remainderSubset);
            remainderSubsetCopy.add(firstElement);
            result.add(remainderSubsetCopy);
        }
        return result;
    }
}
