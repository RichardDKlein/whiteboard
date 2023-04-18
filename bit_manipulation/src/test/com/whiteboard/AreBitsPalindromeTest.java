package com.whiteboard;

import org.junit.Test;

public class AreBitsPalindromeTest {
    @Test
    public void areBitsPalindromeTest() {
        System.out.println();
        System.out.println("Test BitDiff:");
        System.out.println("=============");

        int[] testCases = {
                0b00000000000000000000000000000000,
                0b11111111111111111111111111111111,
                0b01111111111111111111111111111111,
                0b00001111000011111111000011110000,
                0b00001111000011111111000011110001,
        };

        boolean[] expected = {
                true,
                true,
                false,
                true,
                false
        };

        for (int i = 0; i < testCases.length; ++i) {
            BitTestUtils.printBits(testCases[i]);
            boolean areBitsPalindrome = AreBitsPalindrome
                    .areBitsPalindrome(testCases[i]);
            assert(expected[i] == areBitsPalindrome);
            System.out.println("areBitsPalindrome = " + areBitsPalindrome);
        }
    }
}
