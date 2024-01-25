package com.whiteboard.java;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
        doTest(new int[] {}, 0,
                List.of(List.of()));
    }

    @Test
    public void startIndexTooSmall() {
        doTest(new int[] {2, 3, 1, 0, 5}, -1,
                List.of(List.of()));
    }

    @Test
    public void startIndexTooBig() {
        doTest(new int[] {2, 3, 1, 0, 5}, 5,
                List.of(List.of()));
    }

    @Test
    public void solutionExists1() {
        doTest(new int[] {2, 3, 1, 0, 5}, 0,
                List.of(Arrays.asList(0, 2, 3)));
    }

    @Test
    public void solutionExists2() {
        doTest(new int[] {2, 2, 2, 0, 0}, 0,
                List.of(Arrays.asList(0, 2, 4)));
    }

    @Test
    public void solutionExists3() {
        doTest(new int[] {1, 1, 1, 3, 1, 2, 0, 3}, 5,
                List.of(Arrays.asList(5, 3, 6)));
    }

    @Test
    public void solutionExists4() {
        doTest(new int[] {4, 2, 0, 3, 1, 5, 0}, 0,
                List.of(Arrays.asList(0, 4, 3, 6)));
    }

    @Test
    public void multipleSolutionsExist() {
        doTest(new int[] {5, 2, 1, 3, 0, 1, 2, 4, 1}, 3,
                Arrays.asList(
                        Arrays.asList(3, 0, 5, 4),
                        Arrays.asList(3, 6, 4)
                ));
    }

    @Test
    public void noSolution() {
        doTest(new int[] {2, 2, 2, 0, 2}, 0,
                List.of(List.of()));
    }

    private void doTest(int[] a, int iStart, List<List<Integer>> expectedPaths) {
        List<Integer> actual = ArrayHopscotch.arrayHopscotch(a, iStart);
        boolean pathFound = expectedPaths.stream().anyMatch(
                expected -> expected.equals(actual));
        assertTrue(pathFound);
        System.out.println(Arrays.toString(a) + ", start = " + iStart);
        System.out.println("Winning hops = " + actual);
    }
}
