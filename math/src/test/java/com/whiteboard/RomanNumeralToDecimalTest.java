package com.whiteboard;

import org.junit.jupiter.api.Test;

class RomanNumeralToDecimalTest {
    @Test
    void romanNumeralToDecimal() {
        System.out.println();
        System.out.println("Test RomanNumeralToDecimal:");
        System.out.println("===========================");

        String[] romans = new String[] {
                "MCMXLIV",
                "MCMLXVIII",
                "MMXIX"
        };

        RomanNumeralToDecimal instance = new RomanNumeralToDecimal();

        for (String roman : romans) {
            System.out.println("roman = " + roman + ", decimal = "
                    + instance.romanNumeralToDecimal(roman));
        }
    }
}
