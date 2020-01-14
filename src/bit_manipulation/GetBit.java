package bit_manipulation;

/**
 * Get bit.
 */
public final class GetBit {
    private GetBit() {}

    /**
     * Get the value (0 or 1) of the specified bit of the
     * specified int.
     *
     * @param n The int of interest.
     * @param bit The bit to get (where 0 = LSB).
     * @return The value (0 or 1) of the specified bit.
     */
    public static int getBit(int n, int bit) {
        return ((n & (1 << bit)) == 0) ? 0 : 1;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test GetBit:");
        System.out.println("============");

        int n = 0xAAAAAAAA;
        TestUtils.printBits(n);
        for (int i = 0; i < Integer.SIZE; ++i) {
            System.out.println("Bit " + i + " = " + getBit(n, i));
        }
    }
}
