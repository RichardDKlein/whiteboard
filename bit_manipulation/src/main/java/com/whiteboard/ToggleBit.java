package com.whiteboard;

/**
 * Toggle bit.
 */
public class ToggleBit {
    /**
     * Toggle the specified bit in an int.
     *
     * @param n The int of interest.
     * @param bit The bit to toggle (where 0 = LSB).
     * @return A copy of the int, but with the
     * specified bit toggled.
     */
    public int toggleBit(int n, int bit) {
        return n ^ (1 << bit);
    }
}
