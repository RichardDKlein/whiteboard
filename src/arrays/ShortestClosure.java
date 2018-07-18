package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the shortest closure of needles in a haystack, i.e.
 * the shortest interval in the haystack that contains all
 * the needles.
 */
public class ShortestClosure<T> {
    /**
     * Represents a closed interval [left, right] of integers.
     */
    private static class Interval {
        private int left;
        private int right;

        Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        Interval() {
            left = 0;
            right = 0;
        }

        int left() {
            return left;
        }

        int right() {
            return right;
        }

        int length() {
            return right - left + 1;
        }

        boolean valid() {
            return (left >= 0) && (right >= 0) && (right >= left);
        }
    }

    /**
     * A one-dimensional array of elements representing the
     * haystack.
     */
    private T[] haystack;

    /**
     * A one-dimensional array of elements representing the
     * needles.
     */
    private T[] needles;

    /**
     * A data structure identifying the locations of the needles
     * in the haystack. locationLists.get(i) is a sorted list of
     * all the indices in the haystack at which needles[i] appears.
     */
    private List<List<Integer>> locationLists;

    /**
     * General constructor.
     *
     * @param haystack A one-dimensional array of elements representing
     *                 the haystack.
     * @param needles A one-dimensional array of elements representing
     *                the needles.
     */
    public ShortestClosure(T[] haystack, T[] needles) {
        this.haystack = haystack;
        this.needles = needles;
    }

    /**
     * Find the shortest closure, i.e. the shortest interval in
     * the haystack that contains all the needles.
     *
     * The algorithm proceeds in two phases.
     *
     * In Phase 1, we create a locationList for each needle.
     * Each needle's locationList is a sorted list containing
     * every index in the haystack where that needle appears.
     * The running time for this phase is O(k * n) = O(n),
     * where k is the number of needles, which is assumed to
     * be a constant that is small compared to n, the number
     * of elements in the haystack.
     *
     * In Phase 2, we iterate thru the locationLists, identifying
     * each closure that is a candidate for the shortest interval,
     * and keeping track of the shortest interval we've seen so
     * far. The running time for this phase is O(n).
     *
     * Total running time = O(n) + O(n) = O(n).
     *
     * @return An Interval representing the shortest closure.
     */
    public Interval findShortestClosure() {
        Interval shortest = new Interval(0, haystack.length - 1);
        buildLocationLists();
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
     * Build the locationLists, i.e. the data structure identifying
     * the locations of the needles in the haystack.
     */
    private void buildLocationLists() {
        locationLists = new ArrayList<List<Integer>>();
        for (int i = 0; i < needles.length; ++i) {
            List<Integer> list = new ArrayList<>();
            locationLists.add(list);
        }
        for (int i = 0; i < needles.length; ++i) {
            for (int j = 0; j < haystack.length; ++j) {
                if (needles[i] == haystack[j]) {
                    locationLists.get(i).add(j);
                }
            }
        }
    }

    /**
     * Fetch the next closure that is a candidate for the
     * shortest interval. We do this by examining the head
     * of each needle's locationList, finding the min and
     * max, and forming the interval [min, max]. (We also
     * remove the min index from its locationList, so
     * that we don't consider that index again next time.)
     *
     * @return The next closure that is a candidate for the
     * shortest interval.
     */
    private Interval nextCandidate() {
        int min = Integer.MAX_VALUE;
        int max = -1;
        List<Integer> minLocationList = new ArrayList<>();
        for (List<Integer> locationList : locationLists) {
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
        minLocationList.remove(0);
        return new Interval(min, max);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test shortestClosure():");
        System.out.println("=======================");

        Integer needles[] = {
            1, 5, 9
        };

        Integer haystack[] = {
            7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7
        };

        Interval shortest =
                new ShortestClosure(haystack, needles).findShortestClosure();

        System.out.print("needles: { ");
        for (Integer needle : needles) {
            System.out.print(needle + " ");
        }
        System.out.println("}");

        System.out.print("haystack: { ");
        for (int i = 0; i < haystack.length; ++i) {
            if (i == shortest.left()) {
                System.out.print("[** ");
            }
            System.out.print(haystack[i] + " ");
            if (i == shortest.right()) {
                System.out.print("**] ");
            }
        }
        System.out.println("}");

        System.out.println("shortest closure: [" + shortest.left() + ", "
            + shortest.right() + "]");
    }
}
