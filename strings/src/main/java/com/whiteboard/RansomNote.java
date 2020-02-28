package com.whiteboard;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine whether a given ransom note can be constructed by cutting out
 * letters from a given magazine.
 */
public class RansomNote {
    private String note_;
    private String magazine_;
    private Map<Character, Integer> inventory_ = new HashMap<>();

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
    public boolean ransomNote(String note, String magazine) {
        note_ = note;
        magazine_ = magazine;
        takeInventoryOfMagazine();
        return buildRansomNoteFromInventory();
    }

    private void takeInventoryOfMagazine() {
        for (int i = 0; i < magazine_.length(); ++i) {
            char c = magazine_.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (inventory_.containsKey(c)) {
                inventory_.replace(c, inventory_.get(c) + 1);
            } else {
                inventory_.put(c, 1);
            }
        }
    }

    private boolean buildRansomNoteFromInventory() {
        for (int i = 0; i < note_.length(); ++i) {
            char c = note_.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (inventory_.containsKey(c)) {
                int occurrences = inventory_.get(c);
                if (occurrences > 1) {
                    inventory_.replace(c, occurrences - 1);
                } else {
                    inventory_.remove(c);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
