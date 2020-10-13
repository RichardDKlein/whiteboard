package com.whiteboard;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FindPrimesTest {
    @Test
    void findPrimesTest() {
        System.out.println();
        System.out.println("Test FindPrimes:");
        System.out.println("================");

        List<Integer> expected = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        System.out.println("Primes up to 100:");
        List<Integer> primes = FindPrimes.findPrimes(100);
//        assert(primes.equals(expected));
        System.out.println(Arrays.toString(primes.toArray()));
    }
}
