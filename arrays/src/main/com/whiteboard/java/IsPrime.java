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
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
