package com.whiteboard;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class SumPairsInUnsortedArrayTest {

    @Test
    void sumPairsInUnsortedArray() {
        System.out.println();
        System.out.println("Test SumPairsInUnsortedArray:");
        System.out.println("=============================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};

        List<Integer> list = new ArrayList<>();
        for (int integer : a) {
            list.add(integer);
        }

        ShuffleList<Integer> shuffleList = new ShuffleList<>();
        shuffleList.shuffleList(list);
        for (int i = 0; i < a.length; ++i) {
            a[i] = list.get(i);
        }

        System.out.println("unsorted array = " + Arrays.toString(a));

        int sum = 12;

        SumPairsInUnsortedArray instance = new SumPairsInUnsortedArray();
        Set<Pair<Integer, Integer>> pairs = instance.sumPairsInUnsortedArray(a, sum);

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.getKey();
            int p2 = pair.getValue();
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
