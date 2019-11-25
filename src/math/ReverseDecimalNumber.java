package math;

/**
 * Reverse the digits of a decimal number.
 */
public class ReverseDecimalNumber {
    private ReverseDecimalNumber() {}

    /**
     * Reverses the digits of a decimal number.
     *
     * Repeatedly uses the % and / operators to strip off the
     * least significant decimal digit.
     *
     * @param n The decimal number (integer) to reverse.
     * @return An integer equal to n with its digits reversed.
     */
    public static int reverseDecimalNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            int leastSignificantDigit = n % 10;
            reverse = (reverse * 10) + leastSignificantDigit;
            n /= 10;
        }
        return reverse;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ReverseDecimalNumber:");
        System.out.println("==========================");

        int[] n = {0, 1, 12, 123, 1234, 12345, 123456, 1234567, 12345678};

        for (int i = 0; i < n.length; ++i) {
            System.out.println(n[i] + " reversed = "
                    + reverseDecimalNumber(n[i]));
        }
    }
}
