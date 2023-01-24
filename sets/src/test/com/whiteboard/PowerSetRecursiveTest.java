package com.whiteboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PowerSetRecursiveTest {
    @Test
    public void powerSetRecursiveTest() {
        System.out.println();
        System.out.println("Test PowerSetRecursive:");
        System.out.println("=======================");

        Set<Character> set = new HashSet<>(Arrays.asList('a','b','c','d','e'));

        Set<Set<Character>> expected = new HashSet<>();
        expected.add(new HashSet<>(Arrays.asList()));
        expected.add(new HashSet<>(Arrays.asList('a')));
        expected.add(new HashSet<>(Arrays.asList('b')));
        expected.add(new HashSet<>(Arrays.asList('c')));
        expected.add(new HashSet<>(Arrays.asList('d')));
        expected.add(new HashSet<>(Arrays.asList('e')));
        expected.add(new HashSet<>(Arrays.asList('a','b')));
        expected.add(new HashSet<>(Arrays.asList('a','c')));
        expected.add(new HashSet<>(Arrays.asList('a','d')));
        expected.add(new HashSet<>(Arrays.asList('a','e')));
        expected.add(new HashSet<>(Arrays.asList('b','c')));
        expected.add(new HashSet<>(Arrays.asList('b','d')));
        expected.add(new HashSet<>(Arrays.asList('b','e')));
        expected.add(new HashSet<>(Arrays.asList('c','d')));
        expected.add(new HashSet<>(Arrays.asList('c','e')));
        expected.add(new HashSet<>(Arrays.asList('d','e')));
        expected.add(new HashSet<>(Arrays.asList('a','b','c')));
        expected.add(new HashSet<>(Arrays.asList('a','b','d')));
        expected.add(new HashSet<>(Arrays.asList('a','b','e')));
        expected.add(new HashSet<>(Arrays.asList('a','c','d')));
        expected.add(new HashSet<>(Arrays.asList('a','c','e')));
        expected.add(new HashSet<>(Arrays.asList('a','d','e')));
        expected.add(new HashSet<>(Arrays.asList('b','c','d')));
        expected.add(new HashSet<>(Arrays.asList('b','c','e')));
        expected.add(new HashSet<>(Arrays.asList('b','d','e')));
        expected.add(new HashSet<>(Arrays.asList('c','d','e')));
        expected.add(new HashSet<>(Arrays.asList('a','b','c','d')));
        expected.add(new HashSet<>(Arrays.asList('a','b','c','e')));
        expected.add(new HashSet<>(Arrays.asList('a','b','d','e')));
        expected.add(new HashSet<>(Arrays.asList('a','c','d','e')));
        expected.add(new HashSet<>(Arrays.asList('b','c','d','e')));
        expected.add(new HashSet<>(Arrays.asList('a','b','c','d','e')));

        System.out.print("set = ");
        SetTestUtils.printSet(set);

        Set<Set<Character>> powerSet = PowerSetRecursive.powerSetRecursive(set);
        assert(powerSet.equals(expected));
        System.out.println("powerSetRecursive(set) = " + powerSet.size() + " subsets:");
        SetTestUtils.printPowerSet(powerSet);
    }
}
