package com.whiteboard;

import java.util.Arrays;
import java.util.Set;

import com.sun.tools.javac.util.Pair;
import org.junit.jupiter.api.Test;

class SumPairsInSortedArrayTest {
    @Test
    void sumPairsInSortedArray() {
        System.out.println();
        System.out.println("Test SumPairsInSortedArray:");
        System.out.println("===========================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};
        System.out.println("sorted array = " + Arrays.toString(a));

        int sum = 12;
        Set<Pair<Integer, Integer>> pairs = new SumPairsInSortedArray()
                .sumPairsInSortedArray(a, sum);

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.fst;
            int p2 = pair.snd;
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
