package com.whiteboard.java;

import java.util.*;

public final class ShortestClosure {
    private static int[] haystack;
    private static Set<Integer> needles;
    private static Map<Integer, List<Integer>> needleLocationMap;

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
        init(haystack, needles);
        buildNeedleLocationMap();
        return findShortestClosure();
    }

    private static void init(int[] haystack, Set<Integer> needles) {
        ShortestClosure.haystack = haystack;
        ShortestClosure.needles = needles;
        needleLocationMap = new HashMap<>();
    }

    private static void buildNeedleLocationMap() {
        for (int i = 0; i < haystack.length; ++i) {
            if (needles.contains(haystack[i])) {
                needleLocationMap.computeIfAbsent(haystack[i], k -> new ArrayList<>()).add(i);
            }
        }
    }

    private static int[] findShortestClosure() {
        int[] result = {0, haystack.length - 1};
        for (;;) {
            int[] closure = getNextClosure();
            if (closure == null) {
                break;
            }
            if (length(closure) < length(result)) {
                result = closure;
            }
        }
        return result;
    }

    private static int[] getNextClosure() {
        Map<Integer, List<Integer>> nextNeedleLocations = new HashMap<>();
        for (List<Integer> needleLocationList : needleLocationMap.values()) {
            if (needleLocationList.isEmpty()) {
                return null;
            }
            nextNeedleLocations.put(needleLocationList.get(0), needleLocationList);
        }
        int min = Collections.min(nextNeedleLocations.keySet());
        int max = Collections.max(nextNeedleLocations.keySet());
        // Remove min from consideration next time we are called.
        nextNeedleLocations.get(min).remove(0);
        return new int[] {min, max};
    }

    private static int length(int[] closure) {
        return closure[1] - closure[0] + 1;
    }
}
