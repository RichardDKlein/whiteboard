package bit_manipulation;

/**
 * Clear a specified bit.
 */
public class ClearBit {
    private ClearBit() {}

    /**
     * Clear a specified bit in an int.
     *
     * @param n The int of interest.
     * @param bit The bit to clear (where 0 = LSB).
     * @return A copy of the int with the specified
     * bit cleared.
     */
    public static int clearBit(int n, int bit) {
        return n & ~(1 << bit);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test clearBit():");
        System.out.println("================");

        int n = -1;
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ClearBit.clearBit(n, i);
            TestUtils.printBits(n);
        }
    }
}
