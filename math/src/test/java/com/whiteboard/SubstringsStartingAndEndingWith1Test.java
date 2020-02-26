package com.whiteboard;

import org.junit.jupiter.api.Test;

class SubstringsStartingAndEndingWith1Test {
    @Test
    void substringsStartingAndEndingWith1() {
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

        SubstringsStartingAndEndingWith1 instance =
                new SubstringsStartingAndEndingWith1();

        for (int i = 0; i < s.length; ++i) {
            System.out.println("String: " + s[i]
                    + ", Number of substrings starting and ending with '1': "
                    + instance.substringsStartingAndEndingWith1(s[i]));
        }
    }
}
