package com.whiteboard;

import org.junit.jupiter.api.Test;

class GetBitTest {
    @Test
    void getBit() {
        System.out.println();
        System.out.println("Test GetBit:");
        System.out.println("============");

        int n = 0xAAAAAAAA;
        TestUtils.printBits(n);
        for (int i = 0; i < Integer.SIZE; ++i) {
            System.out.println("Bit " + i + " = " +
                    new GetBit().getBit(n, i));
        }
    }
}
