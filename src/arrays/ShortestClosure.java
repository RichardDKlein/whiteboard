package arrays;

import java.util.*;

/**
 * Find the shortest closure of needles in a haystack, i.e.
 * the shortest interval in the haystack that contains all
 * the needles.
 */
public final class ShortestClosure {
    /**
     * Represents a closed interval [min, max] of integers.
     */
    private static class Interval {
        public int min;
        public int max;

        Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }
        int length() {
            return max - min + 1;
        }
        boolean valid() {
            return (min >= 0) && (max >= 0) && (min <= max);
        }
    }

    /**
     * A one-dimensional array of elements representing the
     * haystack.
     */
    private static int[] haystack;

    /**
     * A set of elements representing the needles.
     */
    private static Set<Integer> needles;

    /**
     * A data structure that maps each needle to its locations
     * (indices) in the haystack.
     */
    private static Map<Integer, List<Integer>> needleLocationsMap;

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
     * @param theHaystack A one-dimensional array of elements
     *                    representing the haystack.
     * @param theNeedles A set of elements representing the needles.
     * @return An Interval representing the shortest closure.
     */
    public static Interval
    shortestClosure(int[] theHaystack, Set<Integer> theNeedles) {
        haystack = theHaystack;
        needles = theNeedles;
        Interval shortest = new Interval(0, haystack.length - 1);
        buildNeedleLocationsMap();
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

    /**
     * Build the needleLocationsMap, i.e. the data structure containing
     * the locations (indices) of the needles in the haystack.
     *
     * We do this by examining each element in the haystack, and
     * seeing if it is equal to one of the needles. If so, we append
     * the index of that element to the location list for that needle.
     */
    private static void buildNeedleLocationsMap() {
        needleLocationsMap = new HashMap<>();
        for (int needle : needles) {
            needleLocationsMap.put(needle, new ArrayList<>());
        }
        for (int i = 0; i < haystack.length; ++i) {
            if (needles.contains(haystack[i])) {
                needleLocationsMap.get(haystack[i]).add(i);
            }
        }
    }

    /**
     * Fetch the next closure that is a candidate for the
     * shortest interval.
     *
     * We do this by examining the head of each needle's
     * location list, finding the min and max, and forming
     * the interval [min, max]. (We also remove the min
     * index from its location list, so that we don't
     * consider that index again next time.)
     *
     * @return The next closure that is a candidate for the
     * shortest interval.
     */
    private static Interval nextCandidate() {
        int min = Integer.MAX_VALUE;
        int max = -1;
        int startingNeedle = 0; // must init to make compiler happy
        for (int needle : needles) {
            List<Integer> locationList = needleLocationsMap.get(needle);
            if (locationList.isEmpty()) {
                return new Interval(-1, -1);
            }
            int front = locationList.get(0);
            if (front < min) {
                startingNeedle = needle;
                min = front;
            }
            if (front > max) {
                max = front;
            }
        }
        needleLocationsMap.get(startingNeedle).remove(0);
        return new Interval(min, max);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ShortestClosure:");
        System.out.println("=====================");

        int[] haystack = {
                7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7
        };

        int needleArray[] = {
            1, 5, 9
        };
        Set<Integer> needles = new HashSet<>();
        for (Integer needle : needleArray) {
            needles.add(needle);
        }

        Interval shortest = shortestClosure(haystack, needles);

        System.out.print("needles: { ");
        for (Integer needle : needles) {
            System.out.print(needle + " ");
        }
        System.out.println("}");

        System.out.print("haystack: { ");
        for (int i = 0; i < haystack.length; ++i) {
            if (i == shortest.min) {
                System.out.print("[** ");
            }
            System.out.print(haystack[i] + " ");
            if (i == shortest.max) {
                System.out.print("**] ");
            }
        }
        System.out.println("}");

        System.out.println("shortest closure: [" + shortest.min + ", "
            + shortest.max + "]");
    }
}
