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
        for (int i = 1; i < s.length() - 1; ++i) {
            String longestWithEvenLength = longestCenteredAt(s, i, i + 1);
            if (longestWithEvenLength.length() > result.length()) {
                result = longestWithEvenLength;
            }
            String longestWithOddLength = longestCenteredAt(s, i - 1, i + 1);
            if (longestWithOddLength.length() > result.length()) {
                result = longestWithOddLength;
            }
        }
        return result;
    }

    private static String longestCenteredAt(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return s.substring(left + 1, right);
    }
}
