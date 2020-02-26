package com.whiteboard;

import org.junit.jupiter.api.Test;

class ReverseDecimalNumberTest {
    @Test
    void reverseDecimalNumber() {
        System.out.println();
        System.out.println("Test ReverseDecimalNumber:");
        System.out.println("==========================");

        int[] n = {0, 1, 12, 123, 1234, 12345, 123456, 1234567, 12345678};

        ReverseDecimalNumber instance = new ReverseDecimalNumber();

        for (int i = 0; i < n.length; ++i) {
            System.out.println(n[i] + " reversed = "
                    + instance.reverseDecimalNumber(n[i]));
        }
    }
}
