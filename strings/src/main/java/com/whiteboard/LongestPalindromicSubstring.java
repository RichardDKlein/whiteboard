package com.whiteboard;

/**
 * Find the longest palindromic substring of a given string,
 * i.e. the longest substring that is a palindrome.
 */
public final class LongestPalindromicSubstring {
    private LongestPalindromicSubstring() {
    }

    private static class Interval {
        int min;
        int max;

        Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }
        int length() {
            return max - min + 1;
        }
        boolean isValid() {
            return min >= 0 && min <= max;
        }
    }

    /**
     * Find the longest palindromic substring of a given string,
     * i.e. the longest substring that is a palindrome.
     *
     * @param s The string of interest.
     * @return The longest palindromic substring.
     */
    public static String longestPalindromicSubstring(String s) {
        Interval longest = new Interval(0, 0);
        for (int i = 0; i < s.length(); ++i) {
            Interval longestOdd = longestCenteredAt(s, i, true);
            Interval longestEven = longestCenteredAt(s, i, false);
            if (longestOdd.isValid() && longestOdd.length() > longest.length()) {
                longest = longestOdd;
            }
            if (longestEven.isValid() && longestEven.length() > longest.length()) {
                longest = longestEven;
            }
        }
        return s.substring(longest.min, longest.max + 1);
    }

    private static Interval longestCenteredAt(String s, int center, boolean isLengthOdd) {
        Interval longest = new Interval(-1, -1);
        int left = isLengthOdd ? center - 1 : center;
        int right = center + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            longest.min = left--;
            longest.max = right++;
        }
        return longest;
    }
}
