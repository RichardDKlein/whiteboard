package com.whiteboard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Evaluate an expression that is in Reverse Polish Notation.
 */
public final class ReversePolish {
    private ReversePolish() {
    }

    /**
     * Evaluate an expression that is in Reverse Polish Notation.
     *
     * @param expression A string of the form "<token>,<token>,...",
     *                   where <token> is either an integer, or one
     *                   of the arithmetic operators +, -, *, or /.
     * @return An integer representing the value of the expression.
     */
    public static int reversePolish(String expression) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> tokenStack = new Stack<>();

        String[] tokens = expression.split(",");

        for (String token : tokens) {
            if (operators.contains(token)) {
                int secondOperand = tokenStack.pop();
                int firstOperand = tokenStack.pop();
                switch (token) {
                    case "+":
                        tokenStack.push(firstOperand + secondOperand);
                        break;
                    case "-":
                        tokenStack.push(firstOperand - secondOperand);
                        break;
                    case "*":
                        tokenStack.push(firstOperand * secondOperand);
                        break;
                    case "/":
                        tokenStack.push(firstOperand / secondOperand);
                        break;
                }
            } else {
                tokenStack.push(Integer.parseInt(token));
            }
        }
        return tokenStack.pop();
    }
}
