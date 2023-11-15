package com.whiteboard.java;

/**
 * Find a specified substring in a string.
 */
public final class FindSubstring {
    private FindSubstring() {
    }

    /**
     * Find a specified substring in a string.
     *
     * @param string The string to search.
     * @param substring The substring to find.
     * @return The index of the specified substring in the specified
     * string, or -1 if the substring cannot be found.
     */
    public static int findSubstring(String string, String substring) {
        int lastIndexToCheck = string.length() - substring.length();
        for (int i = 0; i <= lastIndexToCheck; ++i) {
            if (substringFound(string, substring, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean substringFound(String string, String substring,
                                          int startingIndex) {
        for (int i = 0; i < substring.length(); ++i) {
            if (substring.charAt(i) != string.charAt(startingIndex + i)) {
                return false;
            }
        }
        return true;
    }
}
