package com.whiteboard.java;

import java.util.Arrays;

public final class SortString {
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
