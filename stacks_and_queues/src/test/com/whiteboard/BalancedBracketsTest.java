package java.com.whiteboard;

import org.junit.Test;

public class BalancedBracketsTest {
    @Test
    public void balancedBracketsTest() {
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

        boolean[] expected = {
                true,
                false,
                true,
                true,
                true,
                false,
                false,
                true,
                false,
                false
        };

        for (int i = 0; i < expressions.length; ++i) {
            boolean isBalanced = BalancedBrackets.balancedBrackets(expressions[i]);
            assert(isBalanced == expected[i]);
            System.out.println("expression: " + expressions[i]);
            System.out.println("balanced brackets: " + isBalanced);
        }
    }
}
