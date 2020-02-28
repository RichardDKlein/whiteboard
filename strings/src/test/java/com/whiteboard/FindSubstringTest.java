package com.whiteboard;

import org.junit.jupiter.api.Test;

class FindSubstringTest {
    @Test
    void findSubstring() {
        System.out.println();
        System.out.println("Test FindSubstring:");
        System.out.println("===================");

        String testString = "alfalfa romeo";
        String[] testSubstrings = {
                "alfa",
                "rome",
                "alfa romeo",
                "alfa romeos",
                "alfalfa romeo",
                "alfalfa romeos",
                "x"
        };

        FindSubstring instance = new FindSubstring();

        System.out.println("Test string = " + testString);
        for (String s : testSubstrings) {
            int index = instance.findSubstring(testString, s);
            System.out.println("findSubstring(" + s + ") = " + index);
        }
    }
}
