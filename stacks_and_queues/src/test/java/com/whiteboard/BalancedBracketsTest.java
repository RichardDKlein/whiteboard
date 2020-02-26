package com.whiteboard;

import org.junit.jupiter.api.Test;

class BalancedBracketsTest {
    @Test
    void balancedBrackets() {
        System.out.println();
        System.out.println("Test BalancedBrackets:");
        System.out.println("======================");

        String[] expressions = {
                "(a + b)",
                "(a + b) * c)",
                "((a + b) * c)",
                "(((a + b) * c))",
                "[(a + b) * (c + d)]",
                "[(a + b) * (c + d)]]",
                "[(a + b) * (c + d}]",
                "{[(a + b) * (c + d)] / [(e + f) * (g * h)]} * (i + j)",
                "{[(a + b) * (c + d)] / [(e + f) * (g * h)]} * (i + j)}",
                "{[(a + b) * (c + d)] / [(e + f) * (g * h)]} * (i + j"
        };
        for (String expression : expressions) {
            System.out.println("expression: " + expression);
            System.out.println("balanced brackets: "
                    + new BalancedBrackets().balancedBrackets(expression));
        }
    }
}
