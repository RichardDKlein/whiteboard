package math;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a Roman numeral to decimal.
 */
public class RomanNumeralToDecimal {
    private RomanNumeralToDecimal() {}

    /**
     * Converts a Roman numeral to decimal.
     *
     * We start at the end of the Roman numeral string, and
     * work toward the front. We look up each char's decimal
     * value in a hash table, and add it to a running total,
     * UNLESS the current char's value is less than the
     * previous char's value. in that case, we SUBTRACT the
     * current char's value from the running total.
     *
     * @param roman A string containing the Roman numeral to
     *              be converted to decimal.
     * @return The decimal equivalent of the given Roman numeral.
     */
    public static int romanNumeralToDecimal(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char lastChar = roman.charAt(roman.length() - 1);
        int lastVal = map.get(lastChar);
        int prevVal = lastVal;
        int decimal = lastVal;
        for (int i = roman.length() - 2; i >= 0; --i) {
            char currChar = roman.charAt(i);
            int currVal = map.get(currChar);
            if (currVal < prevVal) {
                decimal -= currVal;
            } else {
                decimal += currVal;
            }
            prevVal = currVal;
        }
        return decimal;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test romanNumeralToDecimal():");
        System.out.println("=============================");

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
