package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all primes up to a given integer.
 */
public final class FindPrimes {
    private FindPrimes() {}

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
     * we add 'i' to our list of primes, and set isPrime[k*i] to
     * false for each multiple of i. If isPrime[i] is false, we just
     * go on to the next element, since we've already determined
     * that 'i' is not prime.
     */
    public static List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; ++i) {
            if (isPrime[i]) {
                primes.add(i);
                int j = i + i;
                while (j <= n) {
                    isPrime[j] = false;
                    j += i;
                }
            }
        }
        return primes;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test FindPrimes:");
        System.out.println("================");

        System.out.println("Primes up to 100:");
        List<Integer> primes = findPrimes(100);
        System.out.println(Arrays.toString(primes.toArray()));
    }
}
