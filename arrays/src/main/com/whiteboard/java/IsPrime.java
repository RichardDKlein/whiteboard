package com.whiteboard.java;

public class IsPrime {
    /**
     * Determine whether a given positive integer is prime.
     *
     * @param n A positive integer.
     * @return 'true' if `n` is prime, `false` otherwise.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int sqrtN = (int)Math.round(Math.sqrt(n));
        for (int i = 3; i <= sqrtN; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
