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
            int bit = GetBit.getBit(n, i);
            assert(bit == i % 2);
            System.out.println("Bit " + i + " = " + bit);
        }
    }
}
