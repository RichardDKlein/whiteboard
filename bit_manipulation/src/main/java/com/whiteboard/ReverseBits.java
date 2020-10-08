package com.whiteboard;

/**
 * Reverse bits.
 */
public final class ReverseBits {
    private ReverseBits() {
    }

    /**
     * Reverse the bits of a given int.
     *
     * @param n The int of interest.
     * @return A copy of the int, but with the
     * bits reversed.
     */
    public static int reverseBits(int n) {
        int result = 0;
        int numShifts = Integer.SIZE - 1;
        for (int i = 0; i < numShifts; ++i) {
            result |= n & 1; // OR
            result <<= 1; // shift
            n >>= 1;
        }
        result |= n & 1; // one final OR
        return result;
    }
}
