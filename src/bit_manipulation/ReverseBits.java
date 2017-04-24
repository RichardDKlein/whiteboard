package bit_manipulation;

/**
 * Reverse the bits in an int.
 */
public class ReverseBits {
    private ReverseBits() {}

    public static int reverse(int n) {
        int rev = 0;
        int numShifts = Integer.SIZE - 1;
        for (int i = 0; i < numShifts; ++i) {
            rev |= n & 1; // OR
            rev <<= 1; // shift
            n >>= 1;
        }
        rev |= n & 1; // one final OR
        return rev;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test reverseBits():");
        System.out.println("===================");

        int n = 0xB77BEFD5;

        TestUtils.printBits(n);
        n = ReverseBits.reverse(n);
        System.out.print("Reversed:\n");
        TestUtils.printBits(n);
    }
}
