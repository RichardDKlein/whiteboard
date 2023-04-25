package com.whiteboard.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a Roman numeral to decimal.
 */
public final class RomanNumeralToDecimal {
    private RomanNumeralToDecimal() {
    }

    /**
     * Converts a Roman numeral to decimal.
     *
     * We start at the end of the Roman numeral string, and
     * work toward the front. We look up each char's decimal
     * value in a hash table, and add it to a running total,
     * UNLESS the current char's value is less than the
     * previous char's value. In that case, we SUBTRACT the
     * current char's value from the running total.
     *
     * @param roman A string containing the Roman numeral to
     *              be converted to decimal. You may assume
     *              that the string is a valid Roman numeral.
     * @return The decimal equivalent of the given Roman numeral.
     */
    public static int romanNumeralToDecimal(String roman) {
        Map<Character, Integer> romanToDecimalMap = new HashMap<>();
        romanToDecimalMap.put('I', 1);
        romanToDecimalMap.put('V', 5);
        romanToDecimalMap.put('X', 10);
        romanToDecimalMap.put('L', 50);
        romanToDecimalMap.put('C', 100);
        romanToDecimalMap.put('D', 500);
        romanToDecimalMap.put('M', 1000);

        int result = romanToDecimalMap.get(roman.charAt(roman.length() - 1));
        for (int i = roman.length() - 2; i >= 0; --i) {
            int currDecimal = romanToDecimalMap.get(roman.charAt(i));
            int prevDecimal = romanToDecimalMap.get(roman.charAt(i + 1));
            if (currDecimal < prevDecimal) {
                result -= currDecimal;
            } else {
                result += currDecimal;
            }
        }
        return result;
    }
}
