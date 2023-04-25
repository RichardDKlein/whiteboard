package com.whiteboard.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all primes up to a given integer.
 */
public final class FindPrimes {
    private FindPrimes() {
    }

    /**
     * Find all primes up to a given integer.
     *
     * Our algorithm shall be the famous Sieve of Eratosthenes.
     * We use an an array 'isPrime' to keep track of which integers
     * are prime: isPrime[i] = true if and only if 'i' is prime.
     *
     * All elements of isPrime, except isPrime[0] and isPrime[1],
     * are initialized to true, since as far as we know at the
     * outset, all integers (except 0 and 1) are prime.
     *
     * We then loop thru the isPrime array. If isPrime[i] is true,
     * we add 'i' to our list of primes, and set isPrime[i * j] to
     * false for each multiple 'j' of i. If isPrime[i] is false, we
     * just go on to the next element, since we've already determined
     * that 'i' is not prime.
     *
     * @param n A positive integer.
     * @return A list containing all primes up to and including the
     * given integer.
     */
    public static List<Integer> findPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; ++i) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= n; ++i) {
            if (isPrime[i]) {
                result.add(i);
                for (int j = 2; i * j <= n; ++j) {
                    isPrime[i * j] = false;
                }
            }
        }
        return result;
    }
}
