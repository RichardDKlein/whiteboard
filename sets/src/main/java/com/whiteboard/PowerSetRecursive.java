package com.whiteboard;

import java.util.*;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using a recursive approach.
 */
public class PowerSetRecursive<E> {
    public Set<Set<E>> powerSetRecursive(Set<E> set) {
        Set<Set<E>> powerSet = new HashSet<>();
        if (set.isEmpty()) {
            powerSet.add(new HashSet<>());
            return powerSet;
        }
        List<E> elements = new ArrayList<>(set);
        E firstElement = elements.remove(0);
        Set<E> remainder = new HashSet<>(elements);
        Set<Set<E>> remainderPowerSet = powerSetRecursive(remainder);
        for (Set<E> subset : remainderPowerSet) {
            powerSet.add(new HashSet<>(subset));
            subset.add(firstElement);
            powerSet.add(subset);
        }
        return powerSet;
    }
}
