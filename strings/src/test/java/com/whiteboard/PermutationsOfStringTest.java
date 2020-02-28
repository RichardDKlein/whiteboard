package com.whiteboard;

import org.junit.jupiter.api.Test;
import java.util.Set;

class PermutationsOfStringTest {
    @Test
    void permutationsOfString() {
        System.out.println();
        System.out.println("Test PermutationsOfString:");
        System.out.println("==========================");

        String testString = "abcd";
        Set<String> perms = new PermutationsOfString()
                .permutationsOfString(testString);
        System.out.println("permutationsOfString(" + "\"" + testString
                + "\") returns " + perms.size() + " permutations:");
        for (String perm : perms) {
            System.out.println("\t\"" + perm + "\"");
        }
    }
}
