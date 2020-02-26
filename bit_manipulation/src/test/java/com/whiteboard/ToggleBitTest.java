package com.whiteboard;

import org.junit.jupiter.api.Test;

class ToggleBitTest {
    @Test
    void toggleBit() {
        System.out.println();
        System.out.println("Test ToggleBit:");
        System.out.println("===============");

        ToggleBit instance = new ToggleBit();

        int n = 0;
        TestUtils.printBits(n);

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = instance.toggleBit(n, i);
            TestUtils.printBits(n);
        }
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = instance.toggleBit(n, i);
            TestUtils.printBits(n);
        }
    }
}
