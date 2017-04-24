package bit_manipulation;

/**
 * Determine the bit difference between two ints, i.e. the
 * number of bits that must be toggled to transform one int
 * into the other.
 */
public class BitDiff {
    private BitDiff() {}

    public static int diff(int m, int n) {
        return CountOneBits.count(m ^ n);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test bitDiff():");
        System.out.println("===============");

        int m = 0xAAAAAAAA;
        int n = 0xAAABAACA;

        TestUtils.printBits(m);
        TestUtils.printBits(n);
        System.out.println("Bit diff = " + BitDiff.diff(m, n));
    }
}
