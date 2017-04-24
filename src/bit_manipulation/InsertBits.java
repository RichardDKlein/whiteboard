package bit_manipulation;

/**
 * Insert a contiguous segment of bits into an int.
 */
public class InsertBits {
    private InsertBits() {}

    /**
     * @param n The unsigned int into which the bits are to be inserted.
     * @param bits The bits to be inserted. It is assumed that the bits
     * of interest occupy the least significant bits of 'bits'. The higher
     * order bits will be ignored (and should ideally be set to zero to
     * make the intention clear).
     * @param msb The bit # of the most significant bit in 'n' where the
     * bits are to be inserted.
     * @param lsb The bit # of the least significant bit in 'n' where the
     * bits are to be inserted.
     */
    public static int insert(int n, int bits, int msb, int lsb) {
        int numBits = msb - lsb + 1;
        int mask = (1 << numBits) - 1;
        mask <<= lsb;
        return (n & ~mask) | (bits << lsb);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test insertBits():");
        System.out.println("==================");

        int n = 0;

        System.out.println("Destination bits:");
        TestUtils.printBits(n);
        System.out.println("Bits to insert:");
        int bits = 0x3F;
        TestUtils.printBits(bits);
        n = InsertBits.insert(n, bits, 29, 24);
        TestUtils.printBits(n);
    }
}
