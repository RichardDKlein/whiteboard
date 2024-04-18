package com.whiteboard.java;

public final class IsStringPalindrome {
    /**
     * Determine whether a string is a palindrome.
     *
     * @param s The string of interest.
     * @return A boolean indicating whether ('true) or not ('false')
     * the given string is a palindrome
     */
    public static boolean isStringPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
