package com.whiteboard.java;

import java.util.HashSet;
import java.util.Set;

public final class PermutationsOfString {
    /**
     * Find all the permutations of a given string.
     *
     * @param s The string of interest.
     * @return A set containing all the permutations
     * of the given string.
     */
    public static Set<String> permutationsOfString(String s) {
        Set<String> result = new HashSet<>();
        // base case
        if (s.isEmpty()) {
            result.add("");
            return result;
        }
        // recursive step
        char firstChar = s.charAt(0);
        String remainder = s.substring(1);
        Set<String> permutationsOfRemainder = permutationsOfString(remainder);
        for (String permutationOfRemainder : permutationsOfRemainder) {
            for (int i = 0; i <= permutationOfRemainder.length(); i++) {
                String permutation = insertChar(permutationOfRemainder, firstChar, i);
                result.add(permutation);
            }
        }
        return result;
    }

    private static String insertChar(String s, char c, int index) {
        return s.substring(0, index) + c + s.substring(index);
    }
}
