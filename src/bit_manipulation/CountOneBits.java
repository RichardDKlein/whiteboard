package bit_manipulation;

/**
 * Count the number of '1' bits in an int.
 */
public final class CountOneBits {
    private CountOneBits() {}

    /**
     * Count the number of '1' bits in an int.
     *
     * @param n The int of interest.
     * @return The number of '1' bits in the
     * given int.
     */
    public static int countOneBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            ++count;
        }
        return count;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test CountOneBits:");
        System.out.println("==================");

        int n = 0;

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                countOneBits(n));
        }

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                countOneBits(n));
        }
    }
}
