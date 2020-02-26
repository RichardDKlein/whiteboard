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
        for (String expression : expressions) {
            System.out.println("expression: " + expression);
            System.out.println("value: " + new ReversePolish()
                    .reversePolish(expression));
        }
    }
}
