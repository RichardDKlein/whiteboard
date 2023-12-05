package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArraySubsetsTest {
    @Test
    public void arraySubsetsTest() {
        System.out.println();
        System.out.println("Test ArraySubsets:");
        System.out.println("==================");

        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1));
        input.add(Arrays.asList(1, 2, 3, 4));
        input.add(Arrays.asList(1, 2, 2, 3, 3, 3, 4));
        input.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        input.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(3, 4));
        expected.add(Arrays.asList(3, 3, 4));
        expected.add(Arrays.asList(7, 8, 9, 10));
        expected.add(Arrays.asList(1, 1, 1, 1, 1, 1));

        for (int i = 0; i < expected.size(); ++i) {
            List<Integer> arrA = ArraySubsets.arraySubsets(input.get(i));
            assert(arrA.equals(expected.get(i)));
            System.out.printf("input = %s, arrA = %s\n", input.get(i), arrA);
        }
    }
}
