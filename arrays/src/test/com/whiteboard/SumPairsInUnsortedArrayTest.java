package com.whiteboard;

import java.util.*;
import org.junit.Test;

public class SumPairsInUnsortedArrayTest {
    @Test
    public void sumPairsInUnsortedArrayTest() {
        System.out.println();
        System.out.println("Test SumPairsInUnsortedArray:");
        System.out.println("=============================");

        int[] a = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};

        Integer[][] expectedArray = {
                {6, 6},
                {-1, 13},
                {5, 7},
                {3, 9},
                {-2, 14}
        };

        Set<Set<Integer>> expected = new HashSet<>();
        for (Integer[] pair : expectedArray) {
            expected.add(new HashSet<>(Arrays.asList(pair)));
        }

        System.out.println("sorted array = " + Arrays.toString(a));

        int sum = 12;

        Set<Set<Integer>> unorderedPairs = SumPairsInUnsortedArray.sumPairsInUnsortedArray(a, sum);
        assert(unorderedPairs.equals(expected));

        for (Set<Integer> unorderedPair : unorderedPairs) {
            Iterator<Integer> iterator = unorderedPair.iterator();
            int i1 = iterator.next();
            int i2 = iterator.hasNext() ? iterator.next() : i1;
            System.out.println(i1 + " + " + i2 + " = " + (i1 + i2));
        }
    }
}
