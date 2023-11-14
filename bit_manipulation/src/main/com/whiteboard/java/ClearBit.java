package com.whiteboard.java;

/**
 * Clear a specified bit.
 */
public final class ClearBit {
    private ClearBit() {
    }

    /**
     * Clear a specified bit in an int.
     *
     * @param n The int of interest.
     * @param bit The bit to clear (where 0 = LSB).
     * @return A copy of the int with the specified
     * bit cleared.
     */
    public static int clearBit(int n, int bit) {
        return n ^ (1 << bit);
    }
}
