package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class PowerSetIterativeTest {
    @Test
    void powerSetIterative() {
        System.out.println();
        System.out.println("Test PowerSetIterative:");
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

        PowerSetIterative<Character> instance = new PowerSetIterative<>();

        Set<Set<Character>> powerSet = instance.powerSetIterative(set);
        System.out.println("powerSetIterative(set) = " + powerSet.size() +
                " subsets:");
        testUtils.printPowerSet(powerSet);
    }
}
