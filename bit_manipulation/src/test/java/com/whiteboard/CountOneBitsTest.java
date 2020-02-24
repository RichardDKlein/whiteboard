package com.whiteboard;

import org.junit.jupiter.api.Test;

class CountOneBitsTest {
    @Test
    void countOneBits() {
        System.out.println();
        System.out.println("Test CountOneBits:");
        System.out.println("==================");

        int n = 0;

        CountOneBits instance = new CountOneBits();

        TestUtils.printBits(n);
        System.out.println("Number of 1 bits = " +
                instance.countOneBits(n));

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                    instance.countOneBits(n));
        }

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                    instance.countOneBits(n));
        }
    }
}
