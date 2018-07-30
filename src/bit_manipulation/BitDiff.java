package bit_manipulation;

/**
 * Determine the bit difference between two ints.
 */
public class BitDiff {
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
        return CountOneBits.countOneBits(m ^ n);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test bitDiff():");
        System.out.println("===============");

        int m = 0xAAAAAAAA;
        int n = 0xAAABAACA;

        TestUtils.printBits(m);
        TestUtils.printBits(n);
        System.out.println("Bit diff = " + BitDiff.bitDiff(m, n));
    }
}
