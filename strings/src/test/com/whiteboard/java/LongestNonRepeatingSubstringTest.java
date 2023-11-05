package com.whiteboard.java;

import org.junit.Test;

public class LongestNonRepeatingSubstringTest {
    @Test
    public void longestNonRepeatingSubstringTest() {
        System.out.println();
        System.out.println("Test LongestNonRepeatingSubstring:");
        System.out.println("========================-=========");

        String[] testStrings = {
                "abcdefg",
                "",
                "a",
                "abcabcdabcdeabcdefabcdefg",
                "abcccccccdddddddddefghijkkkkkkk",
        };

        String[] expected = {
                "abcdefg",
                "",
                "a",
                "abcdefg",
                "defghijk"
        };

        for (int i = 0; i < testStrings.length; ++i) {
            String longest = LongestNonRepeatingSubstring.
                    longestNonRepeatingSubstring(testStrings[i]);
            assert(longest.equals(expected[i]));
            System.out.println("longestNonRepeatingSubstring(\""
                    + testStrings[i] + "\") = \"" + longest + "\"");
        }
    }
}
