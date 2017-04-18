package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the shortest closure of needles in a haystack, i.e.
 * the shortest interval in the haystack that contains all
 * the needles.
 */
public class ShortestClosure<T> {
    private T[] haystack;
    private T[] needles;
    private List<List<Integer>> locationLists;
    Interval shortest;

    public ShortestClosure(T[] haystack, T[] needles) {
        this.haystack = haystack;
        this.needles = needles;
    }

    public Interval find() {
        shortest = new Interval(0, haystack.length - 1);
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

        Interval shortest = new ShortestClosure(haystack, needles).find();

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
