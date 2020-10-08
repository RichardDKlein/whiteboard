package com.whiteboard;

import org.junit.jupiter.api.Test;

class CountOneBitsTest {
    @Test
    void countOneBits() {
        System.out.println();
        System.out.println("Test CountOneBits:");
        System.out.println("==================");

        int n = 0;

        ToggleBit toggleBit = new ToggleBit();

        TestUtils.printBits(n);
        int numOneBits = CountOneBits.countOneBits(n);
        assert(numOneBits == 0);
        System.out.println("Number of 1 bits = " + numOneBits);

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = toggleBit.toggleBit(n, i);
            numOneBits = CountOneBits.countOneBits(n);
            assert(numOneBits == i + 1);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " + numOneBits);
        }

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = toggleBit.toggleBit(n, i);
            numOneBits = CountOneBits.countOneBits(n);
            assert(numOneBits == 31 - i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " + numOneBits);
        }
    }
}
