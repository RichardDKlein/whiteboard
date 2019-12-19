package bit_manipulation;

/**
 * Determine the bit difference between two ints.
 */
public final class BitDiff {
    private BitDiff() {}

    /**
     * Determine the bit difference between two ints, i.e.
     * the number of bits that must be toggled to transform
     * one int into the other.
     *
     * @param m One of the ints to compare.
     * @param n The other int to compare.
     * @return The bit difference.
     */
    public static int bitDiff(int m, int n) {
        return countOneBits(m ^ n);
    }

    private static int countOneBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            ++count;
        }
        return count;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test BitDiff:");
        System.out.println("=============");

        int m = 0xAAAAAAAA;
        int n = 0xAAABAACA;

        TestUtils.printBits(m);
        TestUtils.printBits(n);
        System.out.println("Bit diff = " + bitDiff(m, n));
    }
}
