package com.whiteboard;

import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {
    @Test
    void longestPalindromicSubstring() {
        System.out.println();
        System.out.println("Test LongestPalindromicSubstring:");
        System.out.println("=================================");

        String[] testStrings = {
                "Now is the time",
                "This is a PalindromeWithOddLengthtgneLddOhtiWemordnilaP, correct?",
                "This is a PalindromeWithEvenLengthhtgneLnevEhtiWemordnilaP, correct?",
                "able was i ere i saw elba"
        };

        LongestPalindromicSubstring instance = new LongestPalindromicSubstring();

        for (String testString : testStrings) {
            String longest = instance.longestPalindromicSubstring(testString);
            System.out.println("longestPalindromicSubstring(\""
                    + testString + "\") = \"" + longest + "\"");
        }
    }
}
