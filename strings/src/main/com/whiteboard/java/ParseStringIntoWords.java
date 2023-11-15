package com.whiteboard.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Parse a string containing no whitespace into its
 * constituent words.
 */
public final class ParseStringIntoWords {
    private ParseStringIntoWords() {
    }

    /**
     * Parse a string containing no whitespace into its
     * constituent words.
     *
     * @param s The string to parse.
     * @param dictionary A dictionary of legal words.
     * @return A list containing the constituent words;
     * or null if the given string cannot be parsed; or
     * an empty list if the given string is empty.
     */
    public static List<String> parseStringIntoWords(String s, Set<String> dictionary) {
        List<String> result = new ArrayList<>();
        // base case
        if (s.isEmpty()) {
            return result;
        }
        // recursive step
        for (int i = 0; i < s.length(); ++i) {
            String firstWord = s.substring(0, i + 1);
            if (!dictionary.contains(firstWord)) {
                // try a longer first word
                continue;
            }
            String remainder = s.substring(i + 1);
            List<String> parseOfRemainder = parseStringIntoWords(remainder, dictionary);
            if (parseOfRemainder == null) {
                // try a longer first word
                continue;
            }
            result.add(firstWord);
            result.addAll(parseOfRemainder);
            return result;
        }
        // cannot parse
        return null;
    }
}
