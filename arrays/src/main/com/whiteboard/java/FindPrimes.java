package com.whiteboard.java;

import java.util.ArrayList;
import java.util.List;

public class FindPrimes {
    /**
     * Find all primes up to a given integer.</p>
     *
     * Our algorithm is the Sieve of Eratosthenes. We use an array 'isPrime'
     * to keep track of which integers are prime: `isPrime[i]` = `true` if
     * and only if 'i' is prime.</p>
     *
     * All elements of `isPrime` are initialized to `true`, since as far as
     * we know at the outset, all positive integers are prime.</p>
     *
     * We then loop through the `isPrime` array, from `i` = 2` to the square
     * root of `n`. If `isPrime[i]` is `true`, we mark all multiples of `i`
     * as composite (i.e., non-prime). We do this by setting `isPrime[m * i]`
     * to `false` for each multiple of `i`. Here, we take advantage of the
     * following optimization: We need not start from `m` = 2; instead, we
     * can start from `m` = `i`.</p>
     *
     * To see why this is true, suppose that `m < i`. Now, `m` has a prime
     * factorization `p1 * p2 * ... * pN`, where `pI <= m < i` for each of
     * the prime factors `pI`. In particular, `p1 < i`. But that means that
     * `isPrime[m * i]` = `isPrime[p1 * (p2 * ... * pN * i)]` has ALREADY
     * been set to `true`. Why? Because, earlier in the loop through the
     * `isPrime` array, we found that `p1` was prime, and therefore we
     * marked all multiples of `p1` as composite.
     *
     * @param n A positive integer.
     * @return A list containing all primes up to and including `n`.
     */
    public static List<Integer> findPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
