package com.whiteboard.java;

import org.junit.Test;

public class ReverseStringTest {
    @Test
    public void reverseStringTest() {
        System.out.println();
        System.out.println("Test ReverseString:");
        System.out.println("===================");

        String[] testStrings = {
                "a",
                "abc",
                "Hello, world!",
                "Now is the time for all good men to come to the aid of their country"
        };

        String[] expected = {
                "a",
                "cba",
                "!dlrow ,olleH",
                "yrtnuoc rieht fo dia eht ot emoc ot nem doog lla rof emit eht si woN"
        };

        for (int i = 0; i < testStrings.length; ++i) {
            String reversedString = ReverseString.
                    reverseString(testStrings[i]);
            assert(reversedString.equals(expected[i]));
            System.out.println("reversedString(\""
                    + testStrings[i] + "\") = \"" + reversedString + "\"");
        }
    }
}
