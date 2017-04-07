package bit_manipulation;

/**
 * Determine the bit difference between two ints, i.e. the
 * number of bits that must be toggled to transform one int
 * into the other.
 */
public class BitDiff {
    private int m;
    private int n;

    public BitDiff(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int compute() {
        return new CountOneBits(m ^ n).compute();
    }

    public static void test() {
        System.out.println();
        System.out.println("Test bitDiff():");
        System.out.println("===============");

        int m = 0xAAAAAAAA;
        int n = 0xAAABAACA;

        TestUtils.printBits(m);
        TestUtils.printBits(n);
        System.out.println("Bit diff = " + new BitDiff(m, n).compute());
    }
}
