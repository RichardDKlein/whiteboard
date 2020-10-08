package com.whiteboard;

import org.junit.jupiter.api.Test;

class InsertBitsTest {
    @Test
    void insertBits() {
        System.out.println();
        System.out.println("Test InsertBits:");
        System.out.println("================");

        int expected = 0b00111111000000000000000000000000;

        int n = 0;

        System.out.println("Destination bits:");
        TestUtils.printBits(n);
        System.out.println("Bits to insert:");
        int bits = 0x3F;
        TestUtils.printBits(bits);
        n = InsertBits.insertBits(n, bits, 29, 24);
        assert(n == expected);
        TestUtils.printBits(n);
    }
}
