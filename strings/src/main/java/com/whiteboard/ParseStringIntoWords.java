package com.whiteboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Parse a string containing no whitespace into its
 * constituent words.
 */
public class ParseStringIntoWords {
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
    public List<String> parseStringIntoWords(
            String s, Set<String> dictionary) {
        List<String> words = new ArrayList<>();
        if (s.isEmpty()) {
            return words;
        }
        for (int i = 0; i < s.length(); ++i) {
            String firstWord = s.substring(0, i + 1);
            if (!dictionary.contains(firstWord)) {
                continue;
            }
            String remainder = s.substring(i + 1);
            List<String> remainderParse =
                    parseStringIntoWords(remainder, dictionary);
            if (remainderParse == null) {
                // We failed to parse the remainder.
                // Let's try a longer first word.
                continue;
            }
            words.add(firstWord);
            words.addAll(remainderParse);
            return words;
        }
        return null;
    }
}
