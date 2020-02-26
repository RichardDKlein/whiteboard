package com.whiteboard;

/**
 * Reverse bits.
 */
public class ReverseBits {
    /**
     * Reverse the bits of a given int.
     *
     * @param n The int of interest.
     * @return A copy of the int, but with the
     * bits reversed.
     */
    public int reverseBits(int n) {
        int rev = 0;
        int numShifts = Integer.SIZE - 1;
        for (int i = 0; i < numShifts; ++i) {
            rev |= n & 1; // OR
            rev <<= 1; // shift
            n >>= 1;
        }
        rev |= n & 1; // one final OR
        return rev;
    }
}
