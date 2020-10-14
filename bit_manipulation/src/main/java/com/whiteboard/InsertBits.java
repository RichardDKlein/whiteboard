package com.whiteboard;

import sun.jvm.hotspot.utilities.Interval;

/**
 * Insert bits.
 */
public final class InsertBits {
    private InsertBits() {
    }

    /**
     * Insert a contiguous segment of bits into an int.
     *
     * @param n The unsigned int into which the bits are to be inserted.
     * @param bits The bits to be inserted. It is assumed that the bits
     *             of interest occupy the least significant bits of 'bits'.
     *             The higher order bits will be ignored (and should ideally
     *             be set to zero to make the intention clear).
     * @param msb The bit # of the most significant bit in 'n' where the
     *            bits are to be inserted.
     * @param lsb The bit # of the least significant bit in 'n' where the
     *            bits are to be inserted.
     */
    public static int insertBits(int n, int bits, int msb, int lsb) {
        int numBits = msb - lsb + 1;
        int mask = (1 << numBits) - 1;
        int shiftedAndComplementedMask = ~(mask << lsb);
        return (n & shiftedAndComplementedMask) | (bits << lsb);
    }
}
