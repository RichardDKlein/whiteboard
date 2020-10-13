package com.whiteboard;

import java.util.*;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using a recursive approach.
 */
public final class PowerSetRecursive {
    private PowerSetRecursive() {
    }

    public static <E> Set<Set<E>> powerSetRecursive(Set<E> set) {
        Set<Set<E>> powerSet = new HashSet<>();
        if (set.isEmpty()) {
            Set<E> emptySet = new HashSet<>();
            powerSet.add(emptySet);
            return powerSet;
        }
        List<E> elements = new ArrayList<>(set);
        E firstElement = elements.remove(0);
        Set<E> remainderSet = new HashSet<>(elements);
        Set<Set<E>> remainderPowerSet = powerSetRecursive(remainderSet);
        for (Set<E> remainderSubset : remainderPowerSet) {
            powerSet.add(remainderSubset);
            Set<E> copyOfRemainderSubset = new HashSet<>(remainderSubset);
            copyOfRemainderSubset.add(firstElement);
            powerSet.add(copyOfRemainderSubset);
        }
        return powerSet;
    }
}
