package com.whiteboard;

/**
 * Determine the bit difference between two ints.
 */
public class BitDiff {
    /**
     * Determine the bit difference between two ints, i.e.
     * the number of bits that must be toggled to transform
     * one int into the other.
     *
     * @param m One of the ints to compare.
     * @param n The other int to compare.
     * @return The bit difference.
     */
    public int bitDiff(int m, int n) {
        return countOneBits(m ^ n);
    }

    private int countOneBits(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= n - 1;
        }
        return count;
    }
}
