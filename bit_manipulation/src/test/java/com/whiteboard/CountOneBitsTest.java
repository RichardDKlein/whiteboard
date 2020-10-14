package com.whiteboard;

import org.junit.jupiter.api.Test;

class CountOneBitsTest {
    @Test
    void countOneBitsTest() {
        System.out.println();
        System.out.println("Test CountOneBits:");
        System.out.println("==================");

        int n = 0;

        BitTestUtils.printBits(n);
        int numOneBits = CountOneBits.countOneBits(n);
        assert(numOneBits == 0);
        System.out.println("Number of 1 bits = " + numOneBits);

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            numOneBits = CountOneBits.countOneBits(n);
            assert(numOneBits == i + 1);
            BitTestUtils.printBits(n);
            System.out.println("Number of 1 bits = " + numOneBits);
        }

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            numOneBits = CountOneBits.countOneBits(n);
            assert(numOneBits == 31 - i);
            BitTestUtils.printBits(n);
            System.out.println("Number of 1 bits = " + numOneBits);
        }
    }
}
