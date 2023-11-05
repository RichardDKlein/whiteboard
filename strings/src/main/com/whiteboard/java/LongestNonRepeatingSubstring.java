package com.whiteboard.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the longest non-repeating substring of a given string,
 * i.e. the longest substring containing no repeated characters.
 */
public final class LongestNonRepeatingSubstring {
    private LongestNonRepeatingSubstring() {
    }

    /**
     * Find the longest non-repeating substring of a given string,
     * i.e. the longest substring containing no repeated characters.
     *
     * @param s The string of interest.
     * @return The longest non-repeating substring.
     */
    public static String longestNonRepeatingSubstring(String s) {
        int maxStart = 0; // start index of longest substring so far
        int maxLength = 0; // length of longest substring so far
        int currStart = 0; // start index of current candidate
        int currLen = 0; // length of current candidate

        // largest index so far of each character in string
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int index = charIndexMap.getOrDefault(c, -1);
            // If current char is repeated, check if substring ending
            // at previous char is longest so far.
            if (index >= currStart) {
                currLen = (i - 1) - currStart + 1;
                if (currLen > maxLength) {
                    maxLength = currLen;
                    maxStart = currStart;
                }
                // start of new candidate is char after 1st occurrence
                // of repeated char.
                currStart = index + 1;
            }
            charIndexMap.put(c, i);
        }
        // End of string. Check if candidate in progress is longest
        // so far.
        currLen = (s.length() - 1) - currStart + 1;
        if (currLen > maxLength) {
            maxLength = currLen;
            maxStart = currStart;
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}
