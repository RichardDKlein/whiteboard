package com.whiteboard;

import org.junit.jupiter.api.Test;

class ReverseBitsTest {
    @Test
    void reverseBits() {
        System.out.println();
        System.out.println("Test ReverseBits:");
        System.out.println("=================");

        int n = 0xB77BEFD5;

        TestUtils.printBits(n);
        n = new ReverseBits().reverseBits(n);
        System.out.print("Reversed:\n");
        TestUtils.printBits(n);
    }
}
