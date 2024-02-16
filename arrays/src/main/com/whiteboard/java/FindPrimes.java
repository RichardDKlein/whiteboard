package com.whiteboard.java;

import java.util.ArrayList;
import java.util.List;

public class FindPrimes {
    /**
     * Find all primes up to a given integer.
     *
     * Our algorithm shall be the famous Sieve of Eratosthenes. We use
     * an array 'isPrime' to keep track of which integers are prime:
     * `isPrime[i]` = `true` if and only if 'i' is prime.
     *
     * All elements of `isPrime`, except `isPrime[0]` and `isPrime[1]`,
     * are initialized to `true`, since as far as we know at the outset,
     * all integers (except 0 and 1) are prime.
     *
     * We then loop through the `isPrime` array. If `isPrime[i]` is `true`,
     * we add 'i' to our list of primes, and set `isPrime[i * m]` to `false`
     * for each multiple of `i`. If `isPrime[i]` is `false`, we just go on
     * to the next element.
     *
     * When setting `isPrime[i * m]` to `false` for each multiple of `i`,
     * we can take advantage of the following optimization: We need not
     * start from `m` = 2; instead, we can start from `m` = `i`.
     *
     * To see why this is true, suppose that `m < i`. Now, `m` has a prime
     * factorization `p1 * [p2 * ... * pN]`, where `pI <= m < i` for each
     * of the prime factors `pI`. In particular, `p1 < i`. But that means
     * that `isPrime[p1 * [p2 * ... * pN]]` has ALREADY been set to `true`,
     * when earlier in the loop through the `isPrime` array we found that
     * `isPrime[p1]` was true, and therefore set `isPrime[p1 * k]` to
     * `true` for each multiple of `p1`.
     *
     * @param n A positive integer.
     * @return A list containing all primes up to and including the
     * given integer.
     */
    public static List<Integer> findPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; ++i) {
            isPrime[i] = true;
        }
        int sqrtOfN = (int)Math.sqrt(n);
        for (int i = 2; i <= n; ++i) {
            if (isPrime[i]) {
                result.add(i);
                if (i <= sqrtOfN) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return result;
    }
}
