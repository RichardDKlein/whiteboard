package com.whiteboard;

import org.junit.Test;

public class AlphabetizeStringTest {
    @Test
    public void alphabetizeStringTest() {
        System.out.println();
        System.out.println("Test AlphabetizeString:");
        System.out.println("=======================");

        String[] testStrings = {
                "a",
                "abcdefg",
                "gfedcba",
                "cccbbaffffffddddgggggggeeeee"
        };

        String[] expected = {
                "a",
                "abcdefg",
                "abcdefg",
                "abbcccddddeeeeeffffffggggggg"
        };

        for (int i = 0; i < testStrings.length; ++i) {
            String alphabetizedString = AlphabetizeString.
                    alphabetizeString(testStrings[i]);
            assert(alphabetizedString.equals(expected[i]));
            System.out.println("alphabetizedString(\""
                    + testStrings[i] + "\") = \"" + alphabetizedString + "\"");
        }
    }
}
