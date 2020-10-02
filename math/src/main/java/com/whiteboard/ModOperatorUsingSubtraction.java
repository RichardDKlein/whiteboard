package com.whiteboard;

/**
 * Implement the modulo operator, using subtraction instead of division.
 */
public final class ModOperatorUsingSubtraction {
    private ModOperatorUsingSubtraction() {
    }

    /**
     * Implement the modulo operator, using subtraction instead of division.
     *
     * The brute force approach is to subtract the divisor from the dividend
     * until the dividend is less than the divisor.
     *
     * Our algorithm is a more efficient twist on the brute force approach.
     * We start out by subtracting the divisor from the dividend. If the result
     * is still bigger than the divisor, we double the divisor, and subtract
     * again. We keep doubling the divisor, and subtracting from the dividend,
     * until the subtraction would make the dividend go negative. At that point,
     * we make a recursive call, using the now smaller dividend.
     *
     * @param dividend The integer being divided.
     * @param divisor The integer being divided into the dividend.
     * @return An integer equal to (dividend % divisor).
     */
    public static int modOperatorUsingSubtraction(int dividend, int divisor) {
        if (dividend < divisor) {
            return dividend;
        }
        int subtrahend = divisor;
        while (dividend >= subtrahend) {
            dividend -= subtrahend;
            subtrahend <<= 1;
        }
        return modOperatorUsingSubtraction(dividend, divisor);
    }
}
