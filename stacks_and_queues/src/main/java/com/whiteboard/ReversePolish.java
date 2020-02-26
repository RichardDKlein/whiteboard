package com.whiteboard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Evaluate an expression that is in Reverse Polish Notation.
 */
public class ReversePolish {
    /**
     * Evaluate an expression that is in Reverse Polish Notation.
     *
     * @param expression A string of the form "<token>,<token>,...",
     *                   where <token> is either an integer, or one
     *                   of the arithmetic operators +, -, *, or /.
     * @return An integer representing the value of the expression.
     */
    public int reversePolish(String expression) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(",");
        for (String token : tokens) {
            if (operators.contains(token)) {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(firstOperand + secondOperand);
                        break;
                    case "-":
                        stack.push(firstOperand - secondOperand);
                        break;
                    case "*":
                        stack.push(firstOperand * secondOperand);
                        break;
                    case "/":
                        stack.push(firstOperand / secondOperand);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
