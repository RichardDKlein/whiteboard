package arrays;

import java.util.*;

/**
 * Find the shortest closure of needles in a haystack, i.e.
 * the shortest interval in the haystack that contains all
 * the needles.
 */
public final class ShortestClosure {
    private ShortestClosure() {}

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

    private static int[] haystack_;
    private static Set<Integer> needles_;
    private static Map<Integer, List<Integer>> needleLocationsMap_ = new HashMap<>();

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
     * @param haystack A one-dimensional array of elements
     *                 representing the haystack.
     * @param needles A set of elements representing the needles.
     * @return An Interval representing the shortest closure.
     */
    public static Interval
    shortestClosure(int[] haystack, Set<Integer> needles) {
        haystack_ = haystack;
        needles_ = needles;
        buildNeedleLocationsMap();
        Interval shortest = new Interval(0, haystack.length - 1);
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

    private static void buildNeedleLocationsMap() {
        for (int needle : needles_) {
            needleLocationsMap_.put(needle, new ArrayList<>());
        }
        for (int i = 0; i < haystack_.length; ++i) {
            if (needles_.contains(haystack_[i])) {
                needleLocationsMap_.get(haystack_[i]).add(i);
            }
        }
    }
    private static Interval nextCandidate() {
        int min = Integer.MAX_VALUE;
        int max = -1;
        List<Integer> minLocationList = null;
        for (int needle : needles_) {
            List<Integer> locationList = needleLocationsMap_.get(needle);
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
