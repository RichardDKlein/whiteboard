package com.whiteboard.java;

import java.util.*;

public final class ShortestClosure {
    /**
     * Find the shortest closure of needles in a haystack, i.e.
     * the shortest interval in the haystack that contains all
     * the needles.
     *
     * The algorithm proceeds in two phases.
     *
     * In Phase 1, we create a location list for each needle.
     * Each needle's location list is a sorted list containing
     * every index in the haystack where that needle appears.
     * We can create these needle location lists in a single
     * pass over the haystack; therefore, the running time for
     * this phase is O(n).
     *
     * In Phase 2, we iterate thru the location lists, identifying
     * each closure that is a candidate for the shortest interval,
     * and keeping track of the shortest interval we've seen so
     * far. The running time for this phase is O(n).
     *
     * Total running time = O(n) + O(n) = O(n).
     *
     * @param haystack An array of elements representing the haystack.
     * @param needles A set of elements representing the needles.
     * @return A two-element array containing the {start, end} indices
     * of the shortest closure.
     */
    public static int[] shortestClosure(int[] haystack, Set<Integer> needles) {
        Map<Integer, List<Integer>> needleLocations = findNeedleLocations(haystack, needles);
        return findShortestClosure(needleLocations);
    }

    private static Map<Integer, List<Integer>> findNeedleLocations(int[] haystack, Set<Integer> needles) {
        Map<Integer, List<Integer>> needleLocations = new HashMap<>();
        for (int i = 0; i < haystack.length; i++) {
            int straw = haystack[i];
            if (needles.contains(straw)) {
                needleLocations.computeIfAbsent(straw, k -> new ArrayList<>()).add(i);
            }
        }
        return needleLocations;
    }

    private static int[] findShortestClosure(Map<Integer, List<Integer>> needleLocations) {
        int[] shortestClosure = new int[] {0, Integer.MAX_VALUE - 1};
        for (;;) {
            int[] nextClosure = findNextClosure(needleLocations);
            if (nextClosure == null) {
                break;
            }
            if (length(nextClosure) < length(shortestClosure)) {
                shortestClosure = nextClosure;
            }
        }
        return shortestClosure;
    }

    private static int[] findNextClosure(Map<Integer, List<Integer>> needleLocations) {
        Map<Integer, List<Integer>> nextNeedleLocations = new HashMap<>();
        for (List<Integer> needleLocationList : needleLocations.values()) {
            if (needleLocationList.isEmpty()) {
                return null;
            }
            nextNeedleLocations.put(needleLocationList.get(0), needleLocationList);
        }
        int min = Collections.min(nextNeedleLocations.keySet());
        int max = Collections.max(nextNeedleLocations.keySet());
        // remove min location from further consideration
        nextNeedleLocations.get(min).remove(0);
        return new int[] {min, max};
    }

    private static int length(int[] closure) {
        return closure[1] - closure[0] + 1;
    }
}
