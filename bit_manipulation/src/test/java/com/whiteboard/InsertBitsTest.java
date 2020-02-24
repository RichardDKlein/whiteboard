package com.whiteboard;

import org.junit.jupiter.api.Test;

class InsertBitsTest {
    @Test
    void insertBits() {
        System.out.println();
        System.out.println("Test InsertBits:");
        System.out.println("================");

        int n = 0;

        System.out.println("Destination bits:");
        TestUtils.printBits(n);
        System.out.println("Bits to insert:");
        int bits = 0x3F;
        TestUtils.printBits(bits);
        n = new InsertBits().insertBits(
                n, bits, 29, 24);
        TestUtils.printBits(n);
    }
}
