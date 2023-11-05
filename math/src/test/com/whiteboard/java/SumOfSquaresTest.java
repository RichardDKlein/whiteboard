package com.whiteboard.java;

import java.util.*;
import org.junit.Test;

public class SumOfSquaresTest {
    @Test
    public void sumOfSquaresTest() {
        System.out.println();
        System.out.println("Test SumOfSquares:");
        System.out.println("==================");

        int n = 250;
        System.out.println("Generating expected...");
        Set<String> expected = tuplesToStrings(generateExpectedResult(n));
        System.out.println("expected.size() = " + expected.size());
        System.out.println("Generating actual...");
        Set<String> actual = tuplesToStrings(SumOfSquares.sumOfSquares(n));
        System.out.println("actual.size() = " + actual.size());

        System.out.println("Performing comparison...");
        assert(expected.equals(actual));
    }

    private static Set<int[]> generateExpectedResult(int n) {
        Set<int[]> result = new HashSet<>();
        for (int a = 0; a <= n; ++a) {
            for (int b = 0; b <= n; ++b) {
                for (int c = 0; c <= n; ++c) {
                    for (int d = 0; d <= n; ++d) {
                        if (a*a + b*b == c*c + d*d) {
                            int[] solution = {a, b, c, d};
                            result.add(solution);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static Set<String> tuplesToStrings(Set<int[]> set) {
        Set<String> result = new HashSet<>();
        for (int[] tuple : set) {
            String tupleAsString = String.format("%d,%d,%d,%d",
                    tuple[0], tuple[1], tuple[2], tuple[3]);
            result.add(tupleAsString);
        }
        return result;
    }
}
