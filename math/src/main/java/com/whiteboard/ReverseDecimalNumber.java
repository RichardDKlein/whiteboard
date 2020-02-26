package com.whiteboard;

/**
 * Reverse the digits of a decimal number.
 */
public class ReverseDecimalNumber {
    /**
     * Reverses the digits of a decimal number.
     *
     * Repeatedly uses the % and / operators to strip off the
     * least significant decimal digit.
     *
     * @param n The decimal number (positive integer) to reverse.
     * @return An integer equal to n with its digits reversed.
     */
    public int reverseDecimalNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            int leastSignificantDigit = n % 10;
            n /= 10;
            reverse = (reverse * 10) + leastSignificantDigit;
        }
        return reverse;
    }
}
