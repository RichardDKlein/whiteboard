package com.whiteboard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PermutationsOfStringTest {
    @Test
    void permutationsOfStringTest() {
        System.out.println();
        System.out.println("Test PermutationsOfString:");
        System.out.println("==========================");

        Set<String> expectedSet = new HashSet<>(Arrays.asList(
                "abcd",
                "abdc",
                "acbd",
                "acdb",
                "adbc",
                "adcb",

                "bacd",
                "badc",
                "bcad",
                "bcda",
                "bdac",
                "bdca",

                "cabd",
                "cadb",
                "cbad",
                "cbda",
                "cdab",
                "cdba",

                "dabc",
                "dacb",
                "dbac",
                "dbca",
                "dcab",
                "dcba"
        ));

        String testString = "abcd";
        Set<String> perms = PermutationsOfString.permutationsOfString(testString);
        assert(perms.equals(expectedSet));
        System.out.println("permutationsOfString(" + "\"" + testString
                + "\") returns " + perms.size() + " permutations:");
        for (String perm : perms) {
            System.out.println("\t\"" + perm + "\"");
        }
    }
}
