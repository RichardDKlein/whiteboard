package com.whiteboard;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine whether two strings are permutations of each other.
 */
public final class StringsArePermutations {
    private StringsArePermutations() {
    }

    /**
     * Determine whether two strings are permulations of each other.
     *
     * @param s1 One of the strings.
     * @param s2 The other string.
     * @return A boolean indicating whether ('true) or not ('false')
     * s1 and s2 are permutations of each other.
     */
    public static boolean stringsArePermutations(String s1, String s2) {
        Map<Character, Integer> s1Inventory = inventoryCharsInString(s1);
        Map<Character, Integer> s2Inventory = inventoryCharsInString(s2);
        return s1Inventory.equals(s2Inventory);
    }

    private static Map<Character, Integer> inventoryCharsInString(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            Integer count = result.get(c);
            if (count == null) {
                result.put(c, 1);
            } else {
                result.put(c, count + 1);
            }
        }
        return result;
    }
}
