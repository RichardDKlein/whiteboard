package com.whiteboard;

/**
 * Find the longest palindromic substring of a given string,
 * i.e. the longest substring that is a palindrome.
 */
public class LongestPalindromicSubstring {
    /**
     * Find the longest palindromic substring of a given string,
     * i.e. the longest substring that is a palindrome.
     *
     * @param s The string of interest.
     * @return The longest palindromic substring.
     */
    public String longestPalindromicSubstring(String s) {
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
        return s.substring(longest.min_, longest.max_ + 1);
    }

    private Interval longestCenteredAt(String s, int center, boolean isLengthOdd) {
        Interval longest = new Interval(-1, -1);
        int left = isLengthOdd ? center - 1 : center;
        int right = center + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            longest.min_ = left--;
            longest.max_ = right++;
        }
        return longest;
    }

    // ===================================================================
    // INNER CLASSES
    // ===================================================================

    private static class Interval {
        int min_, max_;
        Interval(int min, int max) {
            min_ = min;
            max_ = max;
        }
        int length() {
            return max_ - min_ + 1;
        }
        boolean isValid() {
            return min_ >= 0 && min_ <= max_;
        }
    }
}
