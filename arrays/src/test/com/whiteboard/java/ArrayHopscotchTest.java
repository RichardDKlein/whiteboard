package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayHopscotchTest {
    ArrayHopscotch instance;

    @BeforeClass
    public static void beforeClass() {
        System.out.println();
        System.out.println("Test ArrayHopscotch:");
        System.out.println("====================");
    }

    @Before
    public void beforeEachTest() {
        instance = new ArrayHopscotch();
    }

    @Test
    public void emptyArray() {
        doTest(new int[] {}, 0, new ArrayList<>());
    }

    @Test
    public void startIndexTooSmall() {
        doTest(new int[] {2, 3, 1, 0, 5}, -1, new ArrayList<>());
    }

    @Test
    public void startIndexTooBig() {
        doTest(new int[] {2, 3, 1, 0, 5}, 5, new ArrayList<>());
    }

    @Test
    public void solutionExists1() {
        doTest(new int[] {2, 3, 1, 0, 5}, 0, Arrays.asList(0, 2, 3));
    }

    @Test
    public void solutionExists2() {
        doTest(new int[] {2, 2, 2, 0, 0}, 0, Arrays.asList(0, 2, 4));
    }

    @Test
    public void solutionExists3() {
        doTest(new int[] {1, 1, 1, 3, 1, 2, 0, 3}, 5, Arrays.asList(5, 3, 6));
    }

    @Test
    public void noSolution() {
        doTest(new int[] {2, 2, 2, 0, 2}, 0, new ArrayList<>());
    }

    private void doTest(int[] a, int iStart, List<Integer> expected) {
        List<Integer> actual = instance.arrayHopscotch(a, iStart);
        assert(expected.equals(actual));
        System.out.println(Arrays.toString(a) + ", start = " + iStart);
        System.out.println("Winning hops = " + actual);
    }
}
