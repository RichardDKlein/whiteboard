package com.whiteboard.java;

import java.util.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArraySubsetsTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println();
        System.out.println("Test ArraySubsets:");
        System.out.println("==================");
    }

    @Before
    public void beforeEachTest() {
    }

    @Test
    public void nullArray() {
        List<Integer> a = null;
        List<Integer> expected = Collections.emptyList();
        doTest(a, expected);
    }

    @Test
    public void emptyArray() {
        List<Integer> a = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        doTest(a, expected);
    }

    @Test
    public void arrayWithSingleElement() {
        List<Integer> a = Arrays.asList(1);
        List<Integer> expected = List.of(1);
        doTest(a, expected);
    }

    @Test
    public void arrayWithNoDuplicateElements() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> expected = List.of(3, 4);
        doTest(a, expected);
    }

    @Test
    public void longerArrayWithNoDuplicateElements() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = List.of(7, 8, 9, 10);
        doTest(a, expected);
    }

    @Test
    public void arrayWithSomeDuplicateElements() {
        List<Integer> a = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> expected = List.of(3, 3, 4);
        doTest(a, expected);
    }

    @Test
    public void arrayWithAllDuplicateElements() {
        List<Integer> a = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        List<Integer> expected = List.of(1, 1, 1, 1, 1, 1);
        doTest(a, expected);
    }

    private void doTest(List<Integer> a, List<Integer> expected) {
        List<Integer> actual = ArraySubsets.arraySubsets(a);
        System.out.printf("a = %s, arrA = %s\n", a, actual);
        assert(expected.equals(actual));
    }
}
