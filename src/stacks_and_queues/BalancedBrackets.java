package stacks_and_queues;

import java.util.*;

/**
 * Determine whether, in an expression containing various kinds
 * of brackets, the brackets are properly balanced and nested.
 */
public final class BalancedBrackets {
    private BalancedBrackets() {}

    /**
     * Determine whether, in an expression containing various
     * kinds of brackets, the brackets are properly balanced
     * and nested.
     *
     * Our algorithm is straightforward. We scan the expression
     * from left to right. If we encounter an open bracket, we
     * push it on a stack. If we encounter a close bracket, we
     * pop an open bracket off the stack. (If the stack is empty,
     * the expression is not balanced.) If that open bracket
     * doesn't match the close bracket, the expression is not
     * balanced. If we reach the end of the expression, the
     * expression is balanced if and only if the stack is empty.
     *
     * @param expression A string containing various kinds of
     *                   open and close brackets.
     * @return A boolean indicating whether ('true') or not
     * ('false') the brackets in the expression are properly
     * balanced and nested.
     */
    public static boolean balancedBrackets(String expression) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');

        Stack<Character> openBracketStack = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (bracketMap.containsKey(c)) {
                openBracketStack.push(c);
            } else if (bracketMap.containsValue(c)) {
                if (openBracketStack.isEmpty()) {
                    return false;
                }
                char openBracket = openBracketStack.pop();
                if (bracketMap.get(openBracket) != c) {
                    return false;
                }
            }
        }
        return openBracketStack.isEmpty();
    }

    public static void test() {
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
            System.out.println("balanced brackets: " + balancedBrackets(expression));
        }
    }
}
