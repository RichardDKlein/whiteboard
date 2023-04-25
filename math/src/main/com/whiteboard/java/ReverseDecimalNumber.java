package com.whiteboard.java;

/**
 * Reverse the digits of a decimal number.
 */
public final class ReverseDecimalNumber {
    private ReverseDecimalNumber() {
    }

    /**
     * Reverses the digits of a decimal number.
     *
     * Repeatedly uses the % and / operators to strip off the
     * least significant decimal digit.
     *
     * @param n The decimal number (positive integer) to reverse.
     * @return An integer equal to n with its digits reversed.
     */
    public static int reverseDecimalNumber(int n) {
        int result = 0;
        while (n > 0) {
            int onesDigit = n % 10;
            result = result * 10 + onesDigit;
            n /= 10;
        }
        return result;
    }
}
