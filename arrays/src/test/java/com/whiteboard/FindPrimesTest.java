package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FindPrimesTest {

    @Test
    void findPrimes() {
        System.out.println();
        System.out.println("Test FindPrimes:");
        System.out.println("================");

        System.out.println("Primes up to 100:");
        FindPrimes instance = new FindPrimes();
        List<Integer> primes = instance.findPrimes(100);
        System.out.println(Arrays.toString(primes.toArray()));
    }
}
