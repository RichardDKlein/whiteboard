package com.whiteboard.java;

import org.junit.Test;

public class SubstringsStartingAndEndingWith1Test {
    @Test
    public void substringsStartingAndEndingWith1Test() {
        System.out.println();
        System.out.println("Test SubstringsStartingAndEndingWith1:");
        System.out.println("======================================");

        String[] s = {
                "0000000000",
                "0001000000",
                "0010001000",
                "0100010010",
                "1001001001",
        };

        int[] expected = {
                0,
                0,
                1,
                3,
                6
        };

        for (int i = 0; i < s.length; ++i) {
            int numSubstrings = SubstringsStartingAndEndingWith1.
                    substringsStartingAndEndingWith1(s[i]);
            assert(numSubstrings == expected[i]);
            System.out.println("String: " + s[i] + ", Number of substrings " +
                    "starting and ending with '1': " + numSubstrings);
        }
    }
}
