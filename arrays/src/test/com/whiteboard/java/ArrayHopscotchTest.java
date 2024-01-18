package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
public class ArrayHopscotchTest {
    ArrayHopscotch instance;

    @Before
    public void setUp() {
        instance = new ArrayHopscotch();
    }
    @Test
    public void arrayHopscotchTest() {
        System.out.println();
        System.out.println("Test ArrayHopscotch:");
        System.out.println("====================");

        int[][] a = {
                {},
                {2, 3, 1, 0, 5},
                {2, 3, 1, 0, 5},
                {2, 3, 1, 0, 5},
                {2, 2, 2, 0, 0},
                {2, 2, 2, 0, 2},
                {1, 1, 1, 3, 1, 2, 0, 3}
        };

        int[] iStart = {
                0,
                -1,
                5,
                0,
                0,
                0,
                5
        };

        List<List<Integer>> expected = getExpected();

        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]) + ", start = " + iStart[i]);
            List<Integer> winningHops = instance.arrayHopscotch(a[i], iStart[i]);
            assert(winningHops.equals(expected.get(i)));
            System.out.println("Winning hops = " + winningHops);
        }
    }

    @NotNull
    private static List<List<Integer>> getExpected() {
        List<Integer> expected0 = new ArrayList<>();
        List<Integer> expected1 = new ArrayList<>();
        List<Integer> expected2 = new ArrayList<>();
        List<Integer> expected3 = Arrays.asList(0, 2, 3);
        List<Integer> expected4 = Arrays.asList(0, 2, 4);
        List<Integer> expected5 = new ArrayList<>();
        List<Integer> expected6 = Arrays.asList(5, 3, 6);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(expected0);
        expected.add(expected1);
        expected.add(expected2);
        expected.add(expected3);
        expected.add(expected4);
        expected.add(expected5);
        expected.add(expected6);
        return expected;
    }
}
