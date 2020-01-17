package math;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a Roman numeral to decimal.
 */
public final class RomanNumeralToDecimal {
    private RomanNumeralToDecimal() {}

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
        Map<Character, Integer> romanToDecimalMap = new HashMap<>();
        romanToDecimalMap.put('I', 1);
        romanToDecimalMap.put('V', 5);
        romanToDecimalMap.put('X', 10);
        romanToDecimalMap.put('L', 50);
        romanToDecimalMap.put('C', 100);
        romanToDecimalMap.put('D', 500);
        romanToDecimalMap.put('M', 1000);

        char lastRomanChar = roman.charAt(roman.length() - 1);
        int lastDecimalVal = romanToDecimalMap.get(lastRomanChar);
        int prevDecimalVal = lastDecimalVal;
        int decimal = lastDecimalVal;
        for (int i = roman.length() - 2; i >= 0; --i) {
            char currRomanChar = roman.charAt(i);
            int currDecimalVal = romanToDecimalMap.get(currRomanChar);
            if (currDecimalVal < prevDecimalVal) {
                decimal -= currDecimalVal;
            } else {
                decimal += currDecimalVal;
            }
            prevDecimalVal = currDecimalVal;
        }
        return decimal;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test RomanNumeralToDecimal:");
        System.out.println("===========================");

        String[] romans = new String[] {
                "MCMXLIV",
                "MCMLXVIII",
                "MMXIX"
        };

        for (String roman : romans) {
            System.out.println("roman = " + roman + ", decimal = "
                    + romanNumeralToDecimal(roman));
        }
    }
}
