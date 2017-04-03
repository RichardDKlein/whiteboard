package bit_manipulation;

/**
 * Determine the bit difference between two ints, i.e. the
 * number of bits that must be toggled to transform one int
 * into the other.
 */
public class BitDiff {
    private int m_;
    private int n_;

    public BitDiff(int m, int n) {
        m_ = m;
        n_ = n;
    }

    public int compute() {
        return new CountOneBits(m_ ^ n_).compute();
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
