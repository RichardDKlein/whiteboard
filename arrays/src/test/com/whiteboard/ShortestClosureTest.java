package com.whiteboard;

import org.junit.Test;

import java.util.*;
import com.whiteboard.ShortestClosure.Interval;

class ShortestClosureTest {
    @Test
    void shortestClosureTest() {
        System.out.println();
        System.out.println("Test ShortestClosure:");
        System.out.println("=====================");

        int[] haystack = {
                7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7
        };

        List<Set<Integer>> needles = new ArrayList<>();
        needles.add(new HashSet<>(Arrays.asList(1, 5, 9)));
        needles.add(new HashSet<>(Arrays.asList(5, 7, 9)));
        needles.add(new HashSet<>(Arrays.asList(7, 8, 9)));
        needles.add(new HashSet<>(Arrays.asList(0, 8)));

        Interval[] expected = {
                new Interval(7, 10),
                new Interval(0, 2),
                new Interval(14, 16),
                new Interval(3, 13)
        };


        for (int i = 0; i < needles.size(); ++i) {
            Interval shortest = ShortestClosure.shortestClosure(
                    haystack, needles.get(i));
            assert(shortest.start == expected[i].start);
            assert(shortest.end == expected[i].end);
            System.out.print("needles: { ");
            for (Integer needle : needles.get(i)) {
                System.out.print(needle + " ");
            }
            System.out.println("}");

            System.out.print("haystack: { ");
            for (int j = 0; j < haystack.length; ++j) {
                if (j == shortest.start) {
                    System.out.print("[** ");
                }
                System.out.print(haystack[j] + " ");
                if (j == shortest.end) {
                    System.out.print("**] ");
                }
            }
            System.out.println("}");

            System.out.println("shortest closure: [" + shortest.start + ", "
                    + shortest.end + "]");
        }
    }
}
