package com.whiteboard;

/**
 * Count the number of '1' bits in an int.
 */
public final class CountOneBits {
    private CountOneBits() {
    }

    /**
     * Count the number of '1' bits in an int.
     *
     * @param n The int of interest.
     * @return The number of '1' bits in the
     * given int.
     */
    public static int countOneBits(int n) {
        int result = 0;
        while (n != 0) {
            n = clearLeastSignificantOneBit(n);
            ++result;
        }
        return result;
    }

    private static int clearLeastSignificantOneBit(int n) {
        return n & (n - 1);
    }
}
