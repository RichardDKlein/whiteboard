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
            return end - start + 1;
        }
        // Needed only for the unit test
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Interval)) {
                return false;
            }
            Interval other = (Interval)o;
            return this.start == other.start && this.end == other.end;
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
        for (int i =0; i < haystack.length; ++i) {
            int needle = haystack[i];
            if (needles.contains(needle)) {
                needleLocationMap.get(needle).add(i);
            }
        }
    }

    private static Interval getNextCandidate() {
        int candidateStartIndex = Integer.MAX_VALUE;
        int candidateEndIndex = Integer.MIN_VALUE;

        Integer candidateStartNeedle = null;

        for (int needle : needles) {
            List<Integer> needleLocationList = needleLocationMap.get(needle);
            if (needleLocationList.isEmpty()) {
                return null;
            }
            int smallestIndexOfNeedle = needleLocationList.get(0);
            if (smallestIndexOfNeedle < candidateStartIndex) {
                candidateStartIndex = smallestIndexOfNeedle;
                candidateStartNeedle = needle;
            }
            if (smallestIndexOfNeedle > candidateEndIndex) {
                candidateEndIndex = smallestIndexOfNeedle;
            }
        }
        // Remove the index of the starting needle from that needle's
        // location list, so we don't revisit that index again.
        needleLocationMap.get(candidateStartNeedle).remove(0);

        return new Interval(candidateStartIndex, candidateEndIndex);
    }
}
