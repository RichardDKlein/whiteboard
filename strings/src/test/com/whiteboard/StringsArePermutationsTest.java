package com.whiteboard;

import org.junit.Test;

public class StringsArePermutationsTest {
    @Test
    public void stringsArePermutationsTest() {
        System.out.println();
        System.out.println("Test StringsArePermutations:");
        System.out.println("============================");

        String[][] testStrings = {
                {"Hello, world!", "Hello, world!"},
                {"Hello, world!", "Hello, World!"},
                {"Hello, world!", "!dlrow ,olleH"},
                {"aabbb", "aabbb"},
                {"aabbb", "babab"},
                {"aabbb", "ababa"}
        };

        boolean[] expected = {
                true,
                false,
                true,
                true,
                true,
                false
        };

        for (int i = 0; i < testStrings.length; ++i) {
            String s1 = testStrings[i][0];
            String s2 = testStrings[i][1];
            System.out.println("s1 = " + s1 + ", s2 = " + s2);
            boolean arePermutations =
                    StringsArePermutations.stringsArePermutations(s1, s2);
            assert(arePermutations == expected[i]);
            System.out.println("stringsArePermutations(\"" +
                    s1 + "\", \"" + s2 + "\") = " + arePermutations);
        }
    }
}
