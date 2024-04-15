package com.whiteboard.java;

import java.util.*;

public final class PowerSetRecursive {
    public static <E> Set<Set<E>> powerSetRecursive(Set<E> set) {
        Set<Set<E>> result = new HashSet<>();
        // base case
        if (set.isEmpty()) {
            result.add(new HashSet<>());
            return result;
        }
        // recursive step
        Set<E> setCopy = new HashSet<>(set);
        Iterator<E> iterator = setCopy.iterator();
        E firstElement = iterator.next();
        iterator.remove();
        Set<Set<E>> remainderPowerSet = powerSetRecursive(setCopy);
        for (Set<E> remainderSubset : remainderPowerSet) {
            result.add(remainderSubset);
            Set<E> remainderSubsetCopy = new HashSet<>(remainderSubset);
            remainderSubsetCopy.add(firstElement);
            result.add(remainderSubsetCopy);
        }
        return result;
    }
}
