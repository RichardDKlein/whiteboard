package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class ArrayHopscotchTest {
    @Test
    public void arrayHopscotchTest() {
        System.out.println();
        System.out.println("Test ArrayHopscotch:");
        System.out.println("====================");

        int[][] a = {
                {2, 3, 1, 0, 5},
                {2, 2, 2, 0, 2},
                {1, 1, 1, 3, 1, 2, 0, 3}
        };

        int[] iStart = {
                0,
                0,
                5
        };

        List<Integer> expected0 = Arrays.asList(0, 2, 3);
        List<Integer> expected1 = new ArrayList<>();
        List<Integer> expected2 = Arrays.asList(5, 3, 6);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(expected0);
        expected.add(expected1);
        expected.add(expected2);

        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]) + ", start = " + iStart[i]);
            List<Integer> winningHops = ArrayHopscotch.arrayHopscotch(a[i], iStart[i]);
            assert(winningHops.equals(expected.get(i)));
            System.out.println("Winning hops = " + winningHops);
        }
    }
}
