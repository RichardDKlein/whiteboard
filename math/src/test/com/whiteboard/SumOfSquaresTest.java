package com.whiteboard;

import java.util.*;
import org.junit.Test;

public class SumOfSquaresTest {
    @Test
    public void sumOfSquaresTest() {
        System.out.println();
        System.out.println("Test SumOfSquares:");
        System.out.println("==================");

        System.out.println("Generating expected...");
        Set<String> expected = tuplesToStrings(generateExpectedResult());
        System.out.println("Generating actual...");
        Set<String> actual = tuplesToStrings(SumOfSquares.sumOfSquares());
        System.out.println("Performing comparison...");
        assert(expected.equals(actual));
    }

    private static Set<Integer[]> generateExpectedResult() {
        Set<Integer[]> result = new HashSet<>();
        Map<Integer, Set<Integer[]>> sumOfSquares = new HashMap<>();
        for (int a = 0; a <= 1000; ++a) {
            for (int b = 0; b <= 1000; ++b) {
                int sum = a * a + b * b;
                Integer[] pair = {a, b};
                sumOfSquares.computeIfAbsent(sum, k -> new HashSet<>()).add(pair);
            }
        }
        for (Set<Integer[]> pairList : sumOfSquares.values()) {
            for (Integer[] pair1 : pairList) {
                for (Integer[] pair2 : pairList) {
                    Integer[] solution = {pair1[0], pair1[1], pair2[0], pair2[1]};
                    result.add(solution);
                }
            }
        }
        return result;
    }

    private static Set<String> tuplesToStrings(Set<Integer[]> set) {
        Set<String> result = new HashSet<>();
        for (Integer[] tuple : set) {
            String tupleAsString = String.format("%d,%d,%d,%d",
                    tuple[0], tuple[1], tuple[2], tuple[3]);
            result.add(tupleAsString);
        }
        return result;
    }
}
