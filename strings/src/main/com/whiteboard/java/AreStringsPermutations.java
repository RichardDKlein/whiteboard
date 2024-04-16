package com.whiteboard.java;

import java.util.HashMap;
import java.util.Map;

public final class AreStringsPermutations {
    /**
     * Determine whether two strings are permutations of each other.
     *
     * @param s1 One of the strings.
     * @param s2 The other string.
     * @return A boolean indicating whether ('true) or not ('false')
     * s1 and s2 are permutations of each other.
     */
    public static boolean areStringsPermutations(String s1, String s2) {
        Map<Character, Integer> inventory1 = inventoryStringChars(s1);
        Map<Character, Integer> inventory2 = inventoryStringChars(s2);
        return inventory1.equals(inventory2);
    }

    private static Map<Character, Integer> inventoryStringChars(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = result.getOrDefault(c, 0);
            result.put(c, count + 1);
        }
        return result;
    }
}
