package com.whiteboard.java;

import java.util.*;

/**
 * Find the shortest closure of needles in a haystack, i.e.
 * the shortest interval in the haystack that contains all
 * the needles.
 */
public final class ShortestClosure {
    private ShortestClosure() {
    }

    private static int[] haystack;
    private static Set<Integer> needles;
    private static Map<Integer, List<Integer>> needleLocationLists;

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
        saveCallingParameters(haystack, needles);
        buildNeedleLocationLists();
        return findShortestClosure();
    }

    private static void saveCallingParameters(int[] haystack, Set<Integer> needles) {
        ShortestClosure.haystack = haystack;
        ShortestClosure.needles = needles;
    }

    private static void buildNeedleLocationLists() {
        needleLocationLists = new HashMap<>();
        for (int i = 0; i < haystack.length; ++i) {
            if (needles.contains(haystack[i])) {
                needleLocationLists.computeIfAbsent(haystack[i], k -> new ArrayList<>()).add(i);
            }
        }
    }

    private static int[] findShortestClosure() {
        int[] result = {0, haystack.length - 1};
        for (;;) {
            int[] closure = getNextClosure();
            if (closure == null) break;
            if (intervalLength(closure) < intervalLength(result)) result = closure;
        }
        return result;
    }

    private static int[] getNextClosure() {
        Map<Integer, List<Integer>> smallestNeedleLocations = new HashMap<>();
        for (Integer needle : needles) {
            List<Integer> needleLocationList = needleLocationLists.get(needle);
            if (needleLocationList.isEmpty()) return null;
            smallestNeedleLocations.put(needleLocationList.get(0), needleLocationList);
        }
        Integer min = Collections.min(smallestNeedleLocations.keySet());
        Integer max = Collections.max(smallestNeedleLocations.keySet());
        // Remove min from consideration next time we are called.
        smallestNeedleLocations.get(min).remove(0);
        int[] result = {min, max};
        return result;
    }

    private static int intervalLength(int[] interval) {
        return interval[1] - interval[0] + 1;
    }
}
