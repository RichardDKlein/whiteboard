package com.whiteboard;

import org.junit.jupiter.api.Test;

class StringsArePermutationsTest {
    @Test
    void stringsArePermutations() {
        System.out.println();
        System.out.println("Test StringsArePermutations:");
        System.out.println("============================");

        String[] testStrings = {
                "Hello, world",
                "Hello, world!",
                "!dlrow ,olleH",
                "!dlroW ,olleH",
                "aabbb",
                "aaabb"
        };

        StringsArePermutations instance = new StringsArePermutations();

        for (int i = 0; i < testStrings.length; ++i) {
            for (int j = i; j < testStrings.length; ++j) {
                String s1 = testStrings[i];
                String s2 = testStrings[j];
                boolean p = instance.stringsArePermutations(s1, s2);
                System.out.println("stringsArePermutations(\""
                        + s1 + "\", \"" + s2 + "\") = " + p);
            }
        }
    }
}
