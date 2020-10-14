package com.whiteboard;

import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {
    @Test
    void longestPalindromicSubstringTest() {
        System.out.println();
        System.out.println("Test LongestPalindromicSubstring:");
        System.out.println("=================================");

        String[] testStrings = {
                "Now is the time",
                "This is a PalindromeWithOddLengthtgneLddOhtiWemordnilaP, correct?",
                "This is a PalindromeWithEvenLengthhtgneLnevEhtiWemordnilaP, correct?",
                "able was i ere i saw elba"
        };

        String[] expected = {
                "N",
                "PalindromeWithOddLengthtgneLddOhtiWemordnilaP",
                "PalindromeWithEvenLengthhtgneLnevEhtiWemordnilaP",
                "able was i ere i saw elba"
        };

        for (int i = 0; i < testStrings.length; ++i) {
            String longest = LongestPalindromicSubstring.
                    longestPalindromicSubstring(testStrings[i]);
            assert(longest.equals(expected[i]));
            System.out.println("longestPalindromicSubstring(\""
                    + testStrings[i] + "\") = \"" + longest + "\"");
        }
    }
}
