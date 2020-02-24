package com.whiteboard;

import org.junit.jupiter.api.Test;

class ClearBitTest {
    @Test
    void clearBit() {
        System.out.println();
        System.out.println("Test ClearBit:");
        System.out.println("==============");

        int n = -1;
        TestUtils.printBits(n);
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = new ClearBit().clearBit(n, i);
            TestUtils.printBits(n);
        }
    }
}
