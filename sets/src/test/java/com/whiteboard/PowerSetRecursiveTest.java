package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class PowerSetRecursiveTest {
    @Test
    void powerSetRecursive() {
        System.out.println();
        System.out.println("Test PowerSetRecursive:");
        System.out.println("=======================");

        Set<Character> set = new HashSet<>();

        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        set.add('e');

        TestUtils<Character> testUtils = new TestUtils<>();

        System.out.print("set = ");
        testUtils.printSet(set);

        PowerSetRecursive<Character> instance = new PowerSetRecursive<>();

        Set<Set<Character>> powerSet = instance.powerSetRecursive(set);
        System.out.println("powerSetRecursive(set) = " + powerSet.size() +
                " subsets:");
        testUtils.printPowerSet(powerSet);
    }
}
