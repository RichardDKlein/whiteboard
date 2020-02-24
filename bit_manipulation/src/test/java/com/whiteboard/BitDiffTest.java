package com.whiteboard;

import org.junit.jupiter.api.Test;

class BitDiffTest {
    @Test
    void bitDiff() {
        System.out.println();
        System.out.println("Test BitDiff:");
        System.out.println("=============");

        int m = 0xAAAAAAAA;
        int n = 0xAAABAACA;

        TestUtils.printBits(m);
        TestUtils.printBits(n);
        System.out.println("Bit diff = " +
                new BitDiff().bitDiff(m, n));
    }
}
