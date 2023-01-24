package com.whiteboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumPairsInSortedArrayTest {
    @Test
    public void sumPairsInSortedArrayTest() {
        System.out.println();
        System.out.println("Test SumPairsInSortedArray:");
        System.out.println("===========================");

        int[] a = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};

        Set<UnorderedPair> expected = new HashSet<>();
        expected.add(new UnorderedPair(6, 6));
        expected.add(new UnorderedPair(-1, 13));
        expected.add(new UnorderedPair(5, 7));
        expected.add(new UnorderedPair(3, 9));
        expected.add(new UnorderedPair(-2, 14));

        System.out.println("sorted array = " + Arrays.toString(a));

        int sum = 12;

        Set<UnorderedPair> unorderedPairs = SumPairsInSortedArray.sumPairsInSortedArray(a, sum);
        assert(unorderedPairs.equals(expected));

        for (UnorderedPair unorderedPair : unorderedPairs) {
            int p1 = unorderedPair.first;
            int p2 = unorderedPair.second;
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
