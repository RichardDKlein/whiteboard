package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the shortest closure of needles in a haystack, i.e.
 * the shortest interval in the haystack that contains all
 * the needles.
 */
public class ShortestClosure<T> {
    private T[] haystack_;
    private T[] needles_;
    private List<List<Integer>> locationLists_;
    Interval shortest_;

    public ShortestClosure(T[] haystack, T[] needles) {
        haystack_ = haystack;
        needles_ = needles;
    }

    public Interval compute() {
        shortest_ = new Interval(0, haystack_.length - 1);
        buildLocationLists();
        for (;;) {
            Interval candidate = nextCandidate();
            if (!candidate.valid()) {
                break;
            }
            if (candidate.length() < shortest_.length()) {
                shortest_ = candidate;
            }
        }
        return shortest_;
    }

    private void buildLocationLists() {
        locationLists_= new ArrayList<List<Integer>>();
        for (int i = 0; i < needles_.length; ++i) {
            List<Integer> list = new ArrayList<>();
            locationLists_.add(list);
        }
        for (int i = 0; i < needles_.length; ++i) {
            for (int j = 0; j < haystack_.length; ++j) {
                if (needles_[i] == haystack_[j]) {
                    locationLists_.get(i).add(j);
                }
            }
        }
    }

    private Interval nextCandidate() {
        int min = Integer.MAX_VALUE;
        int max = -1;
        List<Integer> minLocationList = new ArrayList<>();
        for (List<Integer> locationList : locationLists_) {
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

        Interval shortest = new ShortestClosure(haystack, needles).compute();

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
