package com.whiteboard;

/**
 * Set bit.
 */
public class SetBit {
    /**
     * Set the specified bit in an int.
     *
     * @param n The int of interest.
     * @param bit The bit to set (where 0 = LSB).
     * @return A copy of the int, but with the
     * specified bit set.
     */
    public int setBit(int n, int bit) {
        return n | (1 << bit);
    }
}
