package com.whiteboard.java;

/**
 * Test utilities for Strings.
 */
public class StringTestUtils {
    /**
     * Print a long string, automatically wrapping
     * the lines at space characters so that the
     * entire string is visible onscreen.
     *
     * @param s The long string to be printed.
     */
    public static void printLongString(String s) {
        int maxLen = 68;
        int currIndex = 0;
        while (currIndex < s.length()) {
            int nextIndex = Math.min(currIndex + maxLen, s.length());
            String line = s.substring(currIndex, nextIndex);
            if (nextIndex < s.length() && s.charAt(nextIndex) != ' ') {
                int lastSpace = line.lastIndexOf(' ');
                if (lastSpace != -1) {
                    nextIndex = currIndex + lastSpace + 1;
                    line = s.substring(currIndex, nextIndex);
                }
            }
            System.out.println(line);
            currIndex = nextIndex;
        }
    }
}
