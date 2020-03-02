package com.whiteboard;

import java.util.Arrays;

/**
 * Determine whether two strings are permutations of each other.
 */
public class StringsArePermutations {
    /**
     * Determine whether two strings are permulations of each other.
     *
     * @param s1 One of the strings.
     * @param s2 The other string.
     * @return A boolean indicating whether ('true) or not ('false')
     * s1 and s2 are permutations of each other.
     */
    public boolean stringsArePermutations(String s1, String s2) {
        return sort(s1).equals(sort(s2));
    }

    private String sort(String s) {
        char[] buf = s.toCharArray();
        Arrays.sort(buf);
        return new String(buf);
    }
}
