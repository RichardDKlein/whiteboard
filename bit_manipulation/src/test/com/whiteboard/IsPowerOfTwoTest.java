package com.whiteboard;

import org.junit.Test;

public class IsPowerOfTwoTest {
    @Test
    public void isPowerOfTwoTest() {
        System.out.println();
        System.out.println("Test IsPowerOfTwo:");
        System.out.println("==================");

        int n;

        n = 0;
        BitTestUtils.printBits(n);
        boolean isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
        assert(!isPowerOfTwo);
        System.out.println("Is power of 2 = " + isPowerOfTwo);

        n = 1;
        BitTestUtils.printBits(n);
        isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
        assert(isPowerOfTwo);
        System.out.println("Is power of 2 = " + isPowerOfTwo);

        for (int i = 1; i < Integer.SIZE; ++i) {
            n = 0;
            n = SetBit.setBit(n, i);
            BitTestUtils.printBits(n);
            isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
            assert(isPowerOfTwo);
            System.out.println("Is power of 2 = " + isPowerOfTwo);

            n = SetBit.setBit(n, 0);
            isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
            assert(!isPowerOfTwo);
            BitTestUtils.printBits(n);
            System.out.println("Is power of 2 = " + isPowerOfTwo);
        }
    }
}
