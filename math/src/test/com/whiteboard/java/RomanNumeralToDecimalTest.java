package com.whiteboard.java;

import org.junit.Test;

public class RomanNumeralToDecimalTest {
    @Test
    public void romanNumeralToDecimalTest() {
        System.out.println();
        System.out.println("Test RomanNumeralToDecimal:");
        System.out.println("===========================");

        String[] romans = new String[] {
                "MCMXLIV",
                "MCMLXVIII",
                "MMXIX"
        };

        int[] expected = {
                1944,
                1968,
                2019
        };

        for (int i = 0; i < romans.length; ++i) {
            int decimal = RomanNumeralToDecimal.romanNumeralToDecimal(romans[i]);
            assert(decimal == expected[i]);
            System.out.println("roman = " + romans[i] + ", decimal = " + decimal);
        }
    }
}
