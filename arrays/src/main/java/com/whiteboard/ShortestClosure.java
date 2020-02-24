package com.whiteboard;

import java.util.*;

/**
 * Find the shortest closure of needles in a haystack, i.e.
 * the shortest interval in the haystack that contains all
 * the needles.
 */
public class ShortestClosure<E> {

    static class Interval {
        int min_;
        int max_;

        Interval(int min, int max) {
            min_ = min;
            max_ = max;
        }
        protected int length() {
            return max_ - min_ + 1;
        }
        protected boolean valid() {
            return (min_ >= 0) && (min_ <= max_);
        }
    }

    private List<E> haystack_;
    private Set<E> needles_;
    private Map<E, List<Integer>> needleLocationMap_ = new HashMap<>();

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
    public Interval
    shortestClosure(List<E> haystack, Set<E> needles) {
        haystack_ = haystack;
        needles_ = needles;
        buildNeedleLocationMap();
        Interval shortest = new Interval(0, haystack.size() - 1);
        for (;;) {
            Interval candidate = nextCandidate();
            if (!candidate.valid()) {
                break;
            }
            if (candidate.length() < shortest.length()) {
                shortest = candidate;
            }
        }
        return shortest;
    }

    private void buildNeedleLocationMap() {
        for (E needle : needles_) {
            needleLocationMap_.put(needle, new ArrayList<>());
        }
        for (int i = 0; i < haystack_.size(); ++i) {
            if (needles_.contains(haystack_.get(i))) {
                needleLocationMap_.get(haystack_.get(i)).add(i);
            }
        }
    }

    private Interval nextCandidate() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> minLocationList = null;
        for (E needle : needles_) {
            List<Integer> locationList = needleLocationMap_.get(needle);
            if (locationList.isEmpty()) {
                return new Interval(-1, -1);
            }
            int front = locationList.get(0);
            if (front < min) {
                min = front;
                minLocationList = locationList;
            }
            if (front > max) {
                max = front;
            }
        }
        // Remove the min index from its location list,
        // so that we don't consider that index again next time.
        minLocationList.remove(0);
        return new Interval(min, max);
    }
}
