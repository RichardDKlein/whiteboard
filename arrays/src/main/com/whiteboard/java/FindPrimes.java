package com.whiteboard.java;

import java.util.ArrayList;
import java.util.List;

public class FindPrimes {
    /**
     * Find all primes up to a given integer.
     * <p>
     * Our algorithm is the Sieve of Eratosthenes. We use an array 'isPrime'
     * to keep track of which integers are prime: `isPrime[i]` = `true` if
     * and only if 'i' is prime.
     * <p>
     * The `isPrime` array is initialized as follows: `isPrime[2]` is set
     * to `true`, since we know that 2 is prime. In addition, `isPrime[i]
     * is set to `true` for all odd `i` > 1, since as far as we know at the
     * outset, all odd integers > 1, as well as 2, are prime. `isPrime[1]`,
     * as well as `isPrime[i] for all even `i` > 2, are set to `false`.
     * <p>
     * We then loop through the odd indices of the `isPrime` array. If
     * `isPrime[i]` is `true`, we mark all multiples of `i` as composite
     * (i.e., non-prime). We do this by setting `isPrime[m * i]` to `false`
     * for each multiple of `i`. Here, we take advantage of the following
     * optimization: We need not start from `m` = 2; instead, we can start
     * from `m` = `i`.
     * <p>
     * To see why this is true, suppose that `m < i`. Now, `m` has a prime
     * factorization `p1 * p2 * ... * pN`, where `pI <= m < i` for each of
     * the prime factors `pI`. In particular, `p1 < i`. But that means that
     * `isPrime[m * i]` = `isPrime[p1 * (p2 * ... * pN * i)]` has ALREADY
     * been set to `true`. Why? Because, earlier in the loop through the
     * `isPrime` array, we found that `p1` was prime, and therefore we
     * marked all multiples of `p1` as composite.
     *
     * @param n A positive integer.
     * @return A list containing all primes up to and including the
     * given integer.
     */
    public static List<Integer> findPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 2) {
            return result;
        }
        boolean[] isPrime = new boolean[n + 1];
        isPrime[2] = true;
        for (int i = 3; i <= n; i += 2) {
            isPrime[i] = true;
        }
        for (int i = 3; i * i <= n; i += 2) {
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
