package com.whiteboard;

import org.junit.jupiter.api.Test;

class SetBitTest {
    @Test
    void setBit() {
        System.out.println();
        System.out.println("Test SetBit:");
        System.out.println("============");

        int n = 0;
        TestUtils.printBits(n);

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = new SetBit().setBit(n, i);
            TestUtils.printBits(n);
        }
    }
}
