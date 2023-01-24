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

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        int length() {
            return this.end - this.start + 1;
        }
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
     * @param haystack A list of elements representing the haystack.
     * @param needles A set of elements representing the needles.
     * @return An Interval representing the shortest closure.
     */
    public static Interval
    shortestClosure(int[] haystack, Set<Integer> needles) {
        Interval result = new Interval(0, haystack.length - 1);
        ShortestClosure.haystack = haystack;
        ShortestClosure.needles = needles;
        buildNeedleLocationMap();
        for (;;) {
            Interval candidate = getNextCandidate();
            if (candidate == null) {
                return result;
            }
            if (candidate.length() < result.length()) {
                result = candidate;
            }
        }
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

    private static Interval getNextCandidate() {
        int candidateStart = Integer.MAX_VALUE;
        int candidateEnd = Integer.MIN_VALUE;
        List<Integer> candidateStartLocationList = null;
        for (int needle : needles) {
            List<Integer> needleLocationList = needleLocationMap.get(needle);
            if (needleLocationList.isEmpty()) {
                return null;
            }
            int needleSmallestIndex = needleLocationList.get(0);
            if (needleSmallestIndex < candidateStart) {
                candidateStart = needleSmallestIndex;
                candidateStartLocationList = needleLocationList;
            }
            if (needleSmallestIndex > candidateEnd) {
                candidateEnd = needleSmallestIndex;
            }
        }
        candidateStartLocationList.remove(0);
        return new Interval(candidateStart, candidateEnd);
    }
}
