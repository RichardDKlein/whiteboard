package com.whiteboard;

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
        char firstCharOfSubstring = substring.charAt(0);
        int lastIndexToCheck = string.length() - substring.length();
        for (int i = 0; i <= lastIndexToCheck; ++i) {
            if (string.charAt(i) == firstCharOfSubstring) {
                boolean foundSubstring = true;
                for (int j = 1; j < substring.length(); ++j) {
                    if (string.charAt(i + j) != substring.charAt(j)) {
                        foundSubstring = false;
                        break;
                    }
                }
                if (foundSubstring) {
                    return i;
                }
            }
        }
        return -1;
    }
}
