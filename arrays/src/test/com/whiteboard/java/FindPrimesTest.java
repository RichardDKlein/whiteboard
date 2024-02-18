package com.whiteboard.java;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.whiteboard.java.StringTestUtils.printLongString;

public class FindPrimesTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println();
        System.out.println("Test FindPrimes:");
        System.out.println("================");
    }

    @Before
    public void beforeEachTest() {
    }

    @Test
    public void upTo1() {
        List<Integer> expected = Collections.emptyList();
        doTest(1, expected);
    }

    @Test
    public void upTo2() {
        List<Integer> expected = List.of(2);
        doTest(2, expected);
    }

    @Test
    public void upTo1000() {
        List<Integer> expected = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
                67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
                139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
                211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277,
                281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359,
                367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439,
                443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521,
                523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607,
                613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683,
                691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773,
                787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
                877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967,
                971, 977, 983, 991, 997);

        doTest(1000, expected);
    }

    private void doTest(int n, List<Integer> expected) {
        System.out.printf("Primes up to %d:\n", n);

        long startTime = System.nanoTime();
        List<Integer> primes = FindPrimes.findPrimes(n);
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        long microseconds = elapsedTime / 1000;

        printLongString(Arrays.toString(primes.toArray()));
        System.out.printf("Elapsed time = %d microseconds\n\n",
                microseconds);
        assert(primes.equals(expected));
    }
}
