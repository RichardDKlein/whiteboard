package com.whiteboard;

/**
 * Reverse a given string.
 */
public final class ReverseString {
    private ReverseString() {
    }

    /**
     * Reverse the given string.
     *
     * @param s The string to reverse.
     * @return A reversed copy of the given string.
     */
    public static String reverseString(String s) {
        char[] buf = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char tmp = buf[left];
            buf[left] = buf[right];
            buf[right] = tmp;
            ++left;
            --right;
        }
        return new String(buf);
    }
}
