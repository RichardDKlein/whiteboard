package com.whiteboard.java;

import java.util.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayHopscotchTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println();
        System.out.println("Test ArrayHopscotch:");
        System.out.println("====================");
    }

    @Before
    public void beforeEachTest() {
    }

    @Test
    public void emptyArray() {
        int[] a = {};
        int iStart = 0;
        Set<List<Integer>> expected = new HashSet<>();
        doTest(a, iStart, expected);
    }

    @Test
    public void startIndexTooSmall() {
        int[] a = {2, 3, 1, 0, 5};
        int iStart = -1;
        Set<List<Integer>> expected = new HashSet<>();
        doTest(a, iStart, expected);
    }

    @Test
    public void startIndexTooBig() {
        int[] a = {2, 3, 1, 0, 5};
        int iStart = 5;
        Set<List<Integer>> expected = new HashSet<>();
        doTest(a, iStart, expected);
    }

    @Test
    public void startIndexAlreadyWins() {
        int[] a = {2, 3, 1, 0, 5};
        int iStart = 3;
        Set<List<Integer>> expected = new HashSet<>(
                List.of(List.of(3)));
        doTest(a, iStart, expected);
    }

    @Test
    public void oneWinningPath1() {
        int[] a = {2, 3, 1, 0, 5};
        int iStart = 0;
        Set<List<Integer>> expected = new HashSet<>(
                List.of(Arrays.asList(0, 2, 3)));
        doTest(a, iStart, expected);
    }

    @Test
    public void oneWinningPath2() {
        int[] a = {2, 2, 2, 0, 0};
        int iStart = 0;
        Set<List<Integer>> expected = new HashSet<>(
                List.of(Arrays.asList(0, 2, 4)));
        doTest(a, iStart, expected);
    }

    @Test
    public void oneWinningPath3() {
        int[] a = {4, 2, 0, 3, 1, 5, 0};
        int iStart = 0;
        Set<List<Integer>> expected = new HashSet<>(
                List.of(Arrays.asList(0, 4, 3, 6)));
        doTest(a, iStart, expected);
    }

    @Test
    public void twoWinningPaths() {
        int[] a = {1, 1, 1, 3, 1, 2, 0, 3};
        int iStart = 5;
        Set<List<Integer>> expected = new HashSet<>(
                Arrays.asList(
                        Arrays.asList(5, 3, 6),
                        Arrays.asList(5, 7, 4, 3, 6)
                ));
        doTest(a, iStart, expected);
    }

    @Test
    public void threeWinningPaths() {
        int[] a = {5, 2, 1, 3, 0, 1, 2, 4, 1};
        int iStart = 3;
        Set<List<Integer>> expected = new HashSet<>(
                Arrays.asList(
                        Arrays.asList(3, 0, 5, 4),
                        Arrays.asList(3, 0, 5, 6, 4),
                        Arrays.asList(3, 6, 4)
        ));
        doTest(a, iStart, expected);
    }

    @Test
    public void noSolution() {
        int[] a = {2, 2, 2, 0, 2};
        int iStart = 0;
        Set<List<Integer>> expected = new HashSet<>(List.of());
        doTest(a, iStart, expected);
    }

    private void doTest(int[] a, int iStart, Set<List<Integer>> expected) {
        Set<List<Integer>> actual = ArrayHopscotch.arrayHopscotch(a, iStart);
        System.out.printf("a = %s, iStart = %d\n", Arrays.toString(a), iStart);
        System.out.println("Winning hops:");
        printPaths(actual);
        assert(expected.equals(actual));
    }

    private void printPaths(Set<List<Integer>> paths) {
        System.out.println("{");
        for (List<Integer> path : paths) {
            System.out.print("\t[");
            for (int i = 0; i < path.size() - 1; i++) {
                System.out.print(path.get(i) + ", ");
            }
            System.out.println(path.get(path.size() - 1) + "]");
        }
        System.out.println("}");
    }
}
