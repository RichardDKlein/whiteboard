package com.whiteboard.java;

import java.util.HashMap;
import java.util.Map;

public final class RansomNote {
    /**
     * Determine whether a given ransom note can be constructed by
     * cutting out letters from a given magazine.
     *
     * The algorithm is a straightforward application of HashMap.
     * First, we scan the magazine to create a HashMap mapping
     * each char to the number of times it appears in the magazine.
     *
     * Then, we scan the ransom note, decrementing each character's
     * count in the magazine's HashMap, until we either run out of
     * occurrences of a particular char, or reach the end of the
     * ransom note.
     *
     * @param note The ransom note to be constructed.
     * @param magazine The magazine from which letters are to be
     *                 cut out to construct the ransom note.
     * @return A boolean indicating whether ('true') or not ('false')
     * the given ransom note can be constructed from the given magazine.
     */
    public static boolean ransomNote(String note, String magazine) {
        Map<Character, Integer> charInventory = inventoryMagazineChars(magazine);
        return buildNoteFromInventory(note, charInventory);
    }

    private static Map<Character, Integer> inventoryMagazineChars(String magazine) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int count = result.getOrDefault(c, 0);
            result.put(c, count + 1);
        }
        return result;
    }

    private static boolean buildNoteFromInventory(String note, Map<Character, Integer> inventory) {
        for (int i = 0; i < note.length(); i++) {
            char c = note.charAt(i);
            int count = inventory.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            inventory.put(c, count - 1);
        }
        return true;
    }
}
