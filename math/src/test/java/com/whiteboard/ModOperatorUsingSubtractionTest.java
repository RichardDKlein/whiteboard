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

        ModOperatorUsingSubtraction instance = new ModOperatorUsingSubtraction();

        for (int i = 0; i < dividend.length; ++i) {
            System.out.println(dividend[i] + " % " + divisor[i] + " = "
                    + instance.modOperatorUsingSubtraction(dividend[i], divisor[i]));
        }
    }
}
