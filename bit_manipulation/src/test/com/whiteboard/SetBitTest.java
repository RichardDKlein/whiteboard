package com.whiteboard;

import org.junit.Test;

public class SetBitTest {
    @Test
    public void setBitTest() {
        System.out.println();
        System.out.println("Test SetBit:");
        System.out.println("============");

        int expected[] = {
                0b00000000000000000000000000000001,
                0b00000000000000000000000000000011,
                0b00000000000000000000000000000111,
                0b00000000000000000000000000001111,
                0b00000000000000000000000000011111,
                0b00000000000000000000000000111111,
                0b00000000000000000000000001111111,
                0b00000000000000000000000011111111,
                0b00000000000000000000000111111111,
                0b00000000000000000000001111111111,
                0b00000000000000000000011111111111,
                0b00000000000000000000111111111111,
                0b00000000000000000001111111111111,
                0b00000000000000000011111111111111,
                0b00000000000000000111111111111111,
                0b00000000000000001111111111111111,
                0b00000000000000011111111111111111,
                0b00000000000000111111111111111111,
                0b00000000000001111111111111111111,
                0b00000000000011111111111111111111,
                0b00000000000111111111111111111111,
                0b00000000001111111111111111111111,
                0b00000000011111111111111111111111,
                0b00000000111111111111111111111111,
                0b00000001111111111111111111111111,
                0b00000011111111111111111111111111,
                0b00000111111111111111111111111111,
                0b00001111111111111111111111111111,
                0b00011111111111111111111111111111,
                0b00111111111111111111111111111111,
                0b01111111111111111111111111111111,
                0b11111111111111111111111111111111
        };

        int n = 0;
        BitTestUtils.printBits(n);

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = SetBit.setBit(n, i);
            assert(n == expected[i]);
            BitTestUtils.printBits(n);
        }
    }
}