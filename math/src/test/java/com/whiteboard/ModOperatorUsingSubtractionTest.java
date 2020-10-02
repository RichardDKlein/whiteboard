package com.whiteboard;

import org.junit.jupiter.api.Test;

class ModOperatorUsingSubtractionTest {
    @Test
    void modOperatorUsingSubtraction() {
        System.out.println();
        System.out.println("Test ModOperatorUsingSubtraction:");
        System.out.println("=================================");

        int[] dividend = {1, 7, 18, 19, 20, 21, 22, 23, 24, 1999999997};
        int[] divisor  = {3, 7,  6,  6,  6,  6,  6,  6,  6,         10};
        int[] expected = {1, 0,  0,  1,  2,  3,  4,  5,  0,          7};

        for (int i = 0; i < dividend.length; ++i) {
            int mod = ModOperatorUsingSubtraction.modOperatorUsingSubtraction(
                    dividend[i], divisor[i]);
            assert(mod == expected[i]);
            System.out.println(dividend[i] + " % " + divisor[i] + " = " + mod);
        }
    }
}
