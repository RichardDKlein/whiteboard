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
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); ++i) {
            String longestWithOddLength = getLongestCenteredAt(s, i, true);
            String longestWithEvenLength = getLongestCenteredAt(s, i, false);
            if (longestWithOddLength.length() > longest.length()) {
                longest = longestWithOddLength;
            }
            if (longestWithEvenLength.length() > longest.length()) {
                longest = longestWithEvenLength;
            }
        }
        return longest;
    }

    private static String getLongestCenteredAt(String s, int center, boolean isOddLength) {
        int left = isOddLength ? center : center - 1;
        int right = center + 1;
        boolean foundOne = false;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            foundOne = true;
            --left;
            ++right;
        }
        return foundOne ? s.substring(left + 1, right) : "";
    }
}
