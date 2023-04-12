package com.whiteboard;

import org.junit.Test;

public class SortStringTest {
    @Test
    public void sortStringTest() {
        System.out.println();
        System.out.println("Test SortString:");
        System.out.println("================");

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
            String sortedString = SortString.
                    sortString(testStrings[i]);
            assert(sortedString.equals(expected[i]));
            System.out.println("sortedString(\""
                    + testStrings[i] + "\") = \"" + sortedString + "\"");
        }
    }
}
