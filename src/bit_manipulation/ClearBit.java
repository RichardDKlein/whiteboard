package bit_manipulation;

/**
 * Clear a specified bit (where 0 = LSB) in an int.
 */
public class ClearBit {
    private int n;
    private int bit;

    public ClearBit(int n, int bit) {
        this.n = n;
        this.bit = bit;
    }

    public int compute() {
        return n & ~(1 << bit);
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
