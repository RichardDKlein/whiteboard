package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ShortestClosureTest {
    @Test
    void shortestClosure() {
        System.out.println();
        System.out.println("Test ShortestClosure:");
        System.out.println("=====================");

        int[] haystackArray = {
                7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7
        };

        int needleArray[] = {
                1, 5, 9
        };

        List<Integer> haystack = new ArrayList<>();
        for (Integer hay : haystackArray) {
            haystack.add(hay);
        }
        Set<Integer> needles = new HashSet<>();
        for (Integer needle : needleArray) {
            needles.add(needle);
        }

        ShortestClosure instance = new ShortestClosure();
        ShortestClosure.Interval shortest =
                instance.shortestClosure(haystack, needles);

        System.out.print("needles: { ");
        for (Integer needle : needles) {
            System.out.print(needle + " ");
        }
        System.out.println("}");

        System.out.print("haystack: { ");
        for (int i = 0; i < haystack.size(); ++i) {
            if (i == shortest.min_) {
                System.out.print("[** ");
            }
            System.out.print(haystack.get(i) + " ");
            if (i == shortest.max_) {
                System.out.print("**] ");
            }
        }
        System.out.println("}");

        System.out.println("shortest closure: [" + shortest.min_ + ", "
                + shortest.max_ + "]");
    }
}
