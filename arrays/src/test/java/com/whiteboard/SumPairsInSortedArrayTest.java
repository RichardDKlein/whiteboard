package com.whiteboard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import com.whiteboard.SumPairsInSortedArray.Pair;

class SumPairsInSortedArrayTest {
    @Test
    void sumPairsInSortedArray() {
        System.out.println();
        System.out.println("Test SumPairsInSortedArray:");
        System.out.println("===========================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};

        Set<Pair> expected = new HashSet<>();
        expected.add(new Pair(6, 6));
        expected.add(new Pair(-1, 13));
        expected.add(new Pair(5, 7));
        expected.add(new Pair(3, 9));
        expected.add(new Pair(-2, 14));

        System.out.println("sorted array = " + Arrays.toString(a));

        int sum = 12;
        Set<Pair> pairs = SumPairsInSortedArray.sumPairsInSortedArray(a, sum);
        assert(pairs.equals(expected));

        for (Pair pair : pairs) {
            int p1 = pair.first;
            int p2 = pair.second;
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
