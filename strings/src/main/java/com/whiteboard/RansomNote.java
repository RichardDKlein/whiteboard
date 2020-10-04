package com.whiteboard;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine whether a given ransom note can be constructed by cutting out
 * letters from a given magazine.
 */
public final class RansomNote {
    private RansomNote() {
    }

    private static String note;
    private static String magazine;
    private static Map<Character, Integer> inventory = new HashMap<>();

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
    public static boolean ransomNote(
            String note,
            String magazine) {

        RansomNote.note = note;
        RansomNote.magazine = magazine;

        takeInventoryOfMagazine();
        return canCreateNoteFromMagazine();
    }

    private static void takeInventoryOfMagazine() {
        for (int i = 0; i < magazine.length(); ++i) {
            char c = magazine.charAt(i);
            Integer count = inventory.get(c);
            if (count == null) {
                inventory.put(c, 1);
            } else {
                inventory.replace(c, count + 1);
            }
        }
    }

    private static boolean canCreateNoteFromMagazine() {
        for (int i = 0; i < note.length(); ++i) {
            char c = note.charAt(i);
            Integer count = inventory.get(c);
            if (count == null) {
                return false;
            } else if (count == 1) {
                inventory.remove(c);
            } else {
                inventory.replace(c, count - 1);
            }
        }
        return true;
    }
}
