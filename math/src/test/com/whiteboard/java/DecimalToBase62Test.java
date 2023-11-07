package com.whiteboard.java;

import org.junit.Test;

public class DecimalToBase62Test {
    @Test
    public void decimalToBase62Test() {
        System.out.println();
        System.out.println("Test DecimalToBase62:");
        System.out.println("=====================");

        int[] n           = {1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789, 1234567890};
        String[] expected = {"1", "C", "1z", "Ju", "3D7", "W7E", "5BAN", "pnfq", "8M0kX", "1LY7VK"};

        for (int i = 0; i < n.length; ++i) {
            String base36 = DecimalToBase62.decimalToBase62(n[i]);
            assert(base36.equals(expected[i]));
            System.out.printf("decimalToBase36(%d) = %s\n", n[i], base36);
        }
    }
}
