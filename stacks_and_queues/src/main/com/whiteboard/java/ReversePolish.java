package com.whiteboard.java;

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
     *                   You may assume it is a valid reverse polish
     *                   expression.
     * @return An integer representing the value of the expression.
     */
    public static int reversePolish(String expression) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> operandStack = new Stack<>();
        String[] tokens = expression.split(",");
        for (String token : tokens) {
            if (operators.contains(token)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                switch (token) {
                    case "+":
                        operandStack.push(operand1 + operand2);
                        break;
                    case "-":
                        operandStack.push(operand1 - operand2);
                        break;
                    case "*":
                        operandStack.push(operand1 * operand2);
                        break;
                    case "/":
                        operandStack.push(operand1 / operand2);
                        break;
                }
            } else {
                operandStack.push(Integer.parseInt(token));
            }
        }
        return operandStack.pop();
    }
}
