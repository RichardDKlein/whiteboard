package com.whiteboard.java;

import java.util.HashMap;
import java.util.Map;

public final class LongestNonRepeatingSubstring {
    /**
     * Find the longest non-repeating substring of a given string,
     * i.e. the longest substring containing no repeated characters.
     *
     * A brute-force, O(n * n) solution would be to find the longest
     * non-repeating substring starting at each character of the given
     * string.
     *
     * We shall use a better, O(n) solution, known as the "sliding
     * window" algorithm.
     *
     * In this algorithm, we scan the given string from the first
     * character to the last, storing the index of each character
     * in a map.
     *
     * When a repeated character is found, we shall determine whether
     * the substring ending at the previous character is the longest
     * non-repeating substring found so far.
     *
     * Then, we shall consider the character after the PREVIOUS INSTANCE
     * of the repeated character to be the start of the next candidate
     * substring. (We know that any substring with an earlier starting
     * character will be shorter than the substring we just found, due
     * to the repeated character.)
     *
     * @param s The string of interest.
     * @return The longest non-repeating substring.
     */
    public static String longestNonRepeatingSubstring(String s) {
        int currStart, maxStart, currLen, maxLen;
        currStart = maxStart = currLen = maxLen = 0;
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIndex = charToIndexMap.getOrDefault(c, -1);
            if (charIndex >= currStart) {
                currLen = (i - 1) - currStart + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxStart = currStart;
                }
                currStart = charIndex + 1;
            }
            charToIndexMap.put(c, i);
        }
        currLen = (s.length() - 1) - currStart + 1;
        if (currLen > maxLen) {
            maxLen = currLen;
            maxStart = currStart;
        }
        return s.substring(maxStart, maxStart + maxLen);
    }
}
