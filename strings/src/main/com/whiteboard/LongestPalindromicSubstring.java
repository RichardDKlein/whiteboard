package com.whiteboard;

/**
 * Find the longest palindromic substring of a given string,
 * i.e. the longest substring that is a palindrome.
 */
public final class LongestPalindromicSubstring {
    private LongestPalindromicSubstring() {
    }

    /**
     * Find the longest palindromic substring of a given string,
     * i.e. the longest substring that is a palindrome.
     *
     * @param s The string of interest.
     * @return The longest palindromic substring.
     */
    public static String longestPalindromicSubstring(String s) {
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; ++i) {
            String longestEven = longestWithEvenLengthCenteredAt(s, i, i + 1);
            if (longestEven.length() > result.length()) {
                result = longestEven;
            }
        }
        for (int i = 1; i < s.length() - 1; ++i) {
            String longestOdd = longestWithOddLengthCenteredAt(s, i);
            if (longestOdd.length() > result.length()) {
                result = longestOdd;
            }
        }
        return result;
    }

    private static String longestWithEvenLengthCenteredAt(String s, int left, int right) {
        return longestCenteredAt(s, left, right);
    }

    private static String longestWithOddLengthCenteredAt(String s, int center) {
        int left = center - 1;
        int right = center + 1;
        return longestCenteredAt(s, left, right);
    }

    private static String longestCenteredAt(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) {
            return "";
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return s.substring(left + 1, right);
    }
}
