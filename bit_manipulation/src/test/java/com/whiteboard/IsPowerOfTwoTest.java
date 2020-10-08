package com.whiteboard;

import org.junit.jupiter.api.Test;

class IsPowerOfTwoTest {
    @Test
    void isPowerOfTwo() {
        System.out.println();
        System.out.println("Test IsPowerOfTwo:");
        System.out.println("==================");

        int n;

        n = 0;
        TestUtils.printBits(n);
        boolean isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
        assert(!isPowerOfTwo);
        System.out.println("Is power of 2 = " + isPowerOfTwo);

        n = 1;
        TestUtils.printBits(n);
        isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
        assert(isPowerOfTwo);
        System.out.println("Is power of 2 = " + isPowerOfTwo);

        for (int i = 1; i < Integer.SIZE; ++i) {
            n = 0;
            n = SetBit.setBit(n, i);
            TestUtils.printBits(n);
            isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
            assert(isPowerOfTwo);
            System.out.println("Is power of 2 = " + isPowerOfTwo);

            n = SetBit.setBit(n, 0);
            isPowerOfTwo = IsPowerOfTwo.isPowerOfTwo(n);
            assert(!isPowerOfTwo);
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = " + isPowerOfTwo);
        }
    }
}
