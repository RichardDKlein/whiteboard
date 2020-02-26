package com.whiteboard;

import org.junit.jupiter.api.Test;

class CountOneBitsTest {
    @Test
    void countOneBits() {
        System.out.println();
        System.out.println("Test CountOneBits:");
        System.out.println("==================");

        int n = 0;

        CountOneBits countOneBits = new CountOneBits();
        ToggleBit toggleBit = new ToggleBit();

        TestUtils.printBits(n);
        System.out.println("Number of 1 bits = " +
                countOneBits.countOneBits(n));

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = toggleBit.toggleBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                    countOneBits.countOneBits(n));
        }

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = toggleBit.toggleBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                    countOneBits.countOneBits(n));
        }
    }
}
