package com.whiteboard;

import java.util.Arrays;

/**
 * Alphabetize a given string.
 */
public final class SortString {
    private SortString() {
    }

    /**
     * Sort the given string.
     *
     * @param s The string to sort.
     * @return A sorted copy of the given string.
     */
    public static String sortString(String s) {
        char[] buf = s.toCharArray();
        Arrays.sort(buf);
        return new String(buf);
    }
}
