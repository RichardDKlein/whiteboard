package bit_manipulation;

/**
 * Clear a specified bit (where 0 = LSB) in an int.
 */
public class ClearBit {
    private ClearBit() {}

    public static int clear(int n, int bit) {
        return n & ~(1 << bit);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test clearBit():");
        System.out.println("================");

        int n = -1;
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ClearBit.clear(n, i);
            TestUtils.printBits(n);
        }
    }
}
