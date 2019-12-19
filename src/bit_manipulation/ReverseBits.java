package bit_manipulation;

/**
 * Reverse bits.
 */
public final class ReverseBits {
    private ReverseBits() {}

    /**
     * Reverse the bits of a given int.
     *
     * @param n The int of interest.
     * @return A copy of the int, but with the
     * bits reversed.
     */
    public static int reverseBits(int n) {
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
        System.out.println("Test ReverseBits:");
        System.out.println("=================");

        int n = 0xB77BEFD5;

        TestUtils.printBits(n);
        n = reverseBits(n);
        System.out.print("Reversed:\n");
        TestUtils.printBits(n);
    }
}
