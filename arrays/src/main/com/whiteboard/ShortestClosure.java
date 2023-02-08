package com.whiteboard;

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
    private static Map<Integer, List<Integer>> needleLocationMap = new HashMap<>();

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
     * The running time for this phase is O(k * n) = O(n),
     * where k is the number of needles, which is assumed to
     * be a constant that is small compared to n, the number
     * of elements in the haystack.
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
     * @return A two-element array representing the shortest closure.
     * Element 0 contains the starting index, in the haystack, of the
     * closure, and element 1 contains the ending index.
     */
    public static int[]
    shortestClosure(int[] haystack, Set<Integer> needles) {
        saveCallingParameters(haystack, needles);
        buildNeedleLocationMap();
        return findShortestClosure();
    }

    private static void saveCallingParameters(int[] haystack, Set<Integer> needles) {
        ShortestClosure.haystack = haystack;
        ShortestClosure.needles = needles;
    }

    private static void buildNeedleLocationMap() {
        for (int needle : needles) {
            needleLocationMap.put(needle, new ArrayList<>());
        }
        for (int i = 0; i < haystack.length; ++i) {
            if (needles.contains(haystack[i])) {
                needleLocationMap.get(haystack[i]).add(i);
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
            if (intervalLength(closure) < intervalLength(result)) {
                result = closure;
            }
        }
        return result;
    }

    private static int[] getNextClosure() {
        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int startNeedle = -1;
        for (int needle : needles) {
            List<Integer> needleLocationList = needleLocationMap.get(needle);
            if (needleLocationList.isEmpty()) {
                return null;
            }
            int needleSmallestIndex = needleLocationList.get(0);
            if (needleSmallestIndex < result[0]) {
                result[0] = needleSmallestIndex;
                startNeedle = needle;
            }
            if (needleSmallestIndex > result[1]) {
                result[1] = needleSmallestIndex;
            }
        }
        needleLocationMap.get(startNeedle).remove(0);
        return result;
    }

    private static int intervalLength(int[] interval) {
        return interval[1] - interval[0] + 1;
    }
}
