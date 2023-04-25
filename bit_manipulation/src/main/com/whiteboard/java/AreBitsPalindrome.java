package com.whiteboard.java;

/**
 * Determine whether the bits in an int form a palindrome.
 */
public final class AreBitsPalindrome {
    private AreBitsPalindrome() {
    }

    /**
     * Determine whether the bits in an int form a palindrome.
     *
     * @param n The int of interest.
     * @return 'true' if the bits in 'n' form a palindrome,
     * otherwise 'false'.
     */
    public static boolean areBitsPalindrome(int n) {
        int msb = Integer.SIZE - 1;
        int lsb = 0;
        while (msb > lsb) {
            if (getBit(n, msb) != getBit(n, lsb)) {
                return false;
            }
            --msb;
            ++lsb;
        }
        return true;
    }

    private static int getBit(int n, int bit) {
        return (n & (1 << bit)) == 0 ? 0 : 1;
    }
}
