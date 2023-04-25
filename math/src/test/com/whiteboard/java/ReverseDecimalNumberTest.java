package com.whiteboard.java;

import org.junit.Test;

public class ReverseDecimalNumberTest {
    @Test
    public void reverseDecimalNumberTest() {
        System.out.println();
        System.out.println("Test ReverseDecimalNumber:");
        System.out.println("==========================");

        int[] n        = {0, 1, 12, 123, 1234, 12345, 123456, 1234567, 12345678};
        int[] expected = {0, 1, 21, 321, 4321, 54321, 654321, 7654321, 87654321};

        for (int i = 0; i < n.length; ++i) {
            int reversed = ReverseDecimalNumber.reverseDecimalNumber(n[i]);
            assert(reversed == expected[i]);
            System.out.println(n[i] + " reversed = " + reversed);
        }
    }
}
