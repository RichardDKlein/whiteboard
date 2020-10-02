package com.whiteboard;

import org.junit.jupiter.api.Test;

class ReversePolishTest {
    @Test
    void reversePolish() {
        System.out.println();
        System.out.println("Test ReversePolish:");
        System.out.println("===================");

        String[] expressions = {
                "3,4,+",
                "3,4,+,1,-",
                "3,4,+,1,-,5,*",
                "3,4,+,1,-,5,*,10,/"
        };

        int[] expected = {
                7,
                6,
                30,
                3
        };

        for (int i = 0; i < expressions.length; ++i) {
            int value = ReversePolish.reversePolish(expressions[i]);
            assert(value == expected[i]);
            System.out.println("expression: " + expressions[i]);
            System.out.println("value: " + value);
        }
    }
}
