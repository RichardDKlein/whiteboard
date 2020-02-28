package com.whiteboard;

import java.util.HashSet;
import java.util.Set;

/**
 * Find all the permutations of a given string.
 */
public class PermutationsOfString {
    /**
     * Find all the permutations of a given string.
     *
     * @param s The string of interest.
     * @return A set containing all the permutations
     * of the given string.
     */
    public Set<String> permutationsOfString(String s) {
        Set<String> perms = new HashSet<>();
        if (s.isEmpty()) {
            perms.add(s);
            return perms;
        }
        char firstChar = s.charAt(0);
        String rem = s.substring(1);
        Set<String> remPerms = permutationsOfString(rem);
        for (String remPerm : remPerms) {
            for (int i = 0; i <= remPerm.length(); ++i) {
                String perm = insertCharAt(remPerm, firstChar, i);
                perms.add(perm);
            }
        }
        return perms;
    }

    private String insertCharAt(String s, char c, int index) {
        return s.substring(0, index) + c + s.substring(index);
    }
}
