package com.whiteboard;

import org.junit.jupiter.api.Test;

class IsPowerOfTwoTest {
    @Test
    void isPowerOfTwo() {
        System.out.println();
        System.out.println("Test IsPowerOfTwo:");
        System.out.println("==================");

        IsPowerOfTwo instance = new IsPowerOfTwo();

        int n;

        n = 0;
        TestUtils.printBits(n);
        System.out.println("Is power of 2 = "
                + (instance.isPowerOfTwo(n) ? "true" : "false"));

        n = 1;
        TestUtils.printBits(n);
        System.out.println("Is power of 2 = "
                + (instance.isPowerOfTwo(n) ? "true" : "false"));

        SetBit setBit = new SetBit();

        for (int i = 1; i < Integer.SIZE; ++i) {
            n = 0;
            n = setBit.setBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                    + (instance.isPowerOfTwo(n) ? "true" : "false"));
            n = setBit.setBit(n, 0);
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                    + (instance.isPowerOfTwo(n) ? "true" : "false"));
        }
    }
}
