package com.whiteboard.java;

import org.junit.Test;

public class InsertBitsTest {
    @Test
    public void insertBitsTest() {
        System.out.println();
        System.out.println("Test InsertBits:");
        System.out.println("================");

        int expected = 0b00111111000000000000000000000000;

        int n = 0;

        System.out.println("Destination bits:");
        BitTestUtils.printBits(n);
        System.out.println("Bits to insert:");
        int bits = 0x3F;
        BitTestUtils.printBits(bits);
        n = InsertBits.insertBits(n, bits, 29, 24);
        assert(n == expected);
        BitTestUtils.printBits(n);
    }
}
