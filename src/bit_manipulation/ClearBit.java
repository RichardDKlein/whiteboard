package bit_manipulation;

/**
 * Clear a specified bit (where 0 = LSB) in an int.
 */
public class ClearBit {
    private int n_;
    private int bit_;

    public ClearBit(int n, int bit) {
        n_ = n;
        bit_ = bit;
    }

    public int compute() {
        return n_ & ~(1 << bit_);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test clearBit():");
        System.out.println("================");

        int n = -1;
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = new ClearBit(n, i).compute();
            TestUtils.printBits(n);
        }
    }
}
