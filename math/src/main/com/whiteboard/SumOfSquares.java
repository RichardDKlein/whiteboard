package com.whiteboard;

import java.util.*;

/**
 * Find all integers a, b, c, d that are in the range [0..1000],
 * and that satisfy the equation a*a + b*b == c*c + d*d.
 */
public final class SumOfSquares {
    private SumOfSquares() {
    }

    /**
     * Find all integers a, b, c, d that are in the range [0..1000],
     * and that satisfy the equation a*a + b*b == c*c + d*d.
     *
     * The brute force solution is O(n*n*n*n), but we can do better.
     * First, we find all possible pairs {a,b} that satisfy each possible
     * sum of squares (a*a + b*b). Then, for each sum, we simply generate
     * all possible permutations of two of those pairs. This solution is
     * O(n*n).
     *
     * @return A set of all possible 4-tuples {a, b, c, d} that satisfy
     * the equation a*a + b*b == c*c + d*d.
     */
    public static Set<Integer[]> sumOfSquares() {
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
}
