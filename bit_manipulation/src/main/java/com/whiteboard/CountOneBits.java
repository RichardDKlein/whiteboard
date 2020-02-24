package com.whiteboard;

/**
 * Count the number of '1' bits in an int.
 */
public class CountOneBits {
    /**
     * Count the number of '1' bits in an int.
     *
     * @param n The int of interest.
     * @return The number of '1' bits in the
     * given int.
     */
    public int countOneBits(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= n - 1;
        }
        return count;
    }
}
