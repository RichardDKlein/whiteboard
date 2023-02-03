package com.whiteboard;

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
     *              be converted to decimal.
     * @return The decimal equivalent of the given Roman numeral.
     */
    public static int romanNumeralToDecimal(String roman) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int[] decimal = new int[roman.length()];
        for (int i = 0; i < roman.length(); ++i) {
            decimal[i] = map.get(roman.charAt(i));
        }
        result = decimal[roman.length() - 1];
        for (int i = roman.length() - 2; i >= 0; --i) {
            if (decimal[i] < decimal[i + 1]) {
                result -= decimal[i];
            } else {
                result += decimal[i];
            }
        }
        return result;
    }
}
