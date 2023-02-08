package com.whiteboard;

import java.util.*;
import org.junit.Test;

public class ShortestClosureTest {
    @Test
    public void shortestClosureTest() {
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

        int[][] expected = {
                {7, 10},
                {0, 2},
                {14, 16},
                {3, 13}
        };


        for (int i = 0; i < needles.size(); ++i) {
            int[] shortest = ShortestClosure.shortestClosure(
                    haystack, needles.get(i));
            assert(shortest[0] == expected[i][0]);
            assert(shortest[1] == expected[i][1]);
            System.out.print("needles: { ");
            for (Integer needle : needles.get(i)) {
                System.out.print(needle + " ");
            }
            System.out.println("}");

            System.out.print("haystack: { ");
            for (int j = 0; j < haystack.length; ++j) {
                if (j == shortest[0]) {
                    System.out.print("[** ");
                }
                System.out.print(haystack[j] + " ");
                if (j == shortest[1]) {
                    System.out.print("**] ");
                }
            }
            System.out.println("}");

            System.out.println("shortest closure: [" + shortest[0] + ", "
                    + shortest[1] + "]");
        }
    }
}
