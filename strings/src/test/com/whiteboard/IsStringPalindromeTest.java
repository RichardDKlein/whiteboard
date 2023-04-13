package com.whiteboard;

import org.junit.Test;

public class IsStringPalindromeTest {
    @Test
    public void isStringPalindromeTest() {
        System.out.println();
        System.out.println("Test IsStringPalindrome:");
        System.out.println("========================");

        String[] testStrings = {
                "able was i ere i saw elba",
                "able was i ere u saw elba"
        };

        boolean[] expected = {
                true,
                false
        };

        for (int i = 0; i < testStrings.length; ++i) {
            String s = testStrings[i];
            System.out.println("s = " + s);
            boolean isPalindrome =
                    IsStringPalindrome.isStringPalindrome(s);
            assert(isPalindrome == expected[i]);
            System.out.println("isStringPalindrome(\"" +
                    s + "\") = " + isPalindrome);
        }
    }
}
