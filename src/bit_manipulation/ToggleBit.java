package bit_manipulation;

/**
 * Toggle the specified bit (where 0 = LSB) in an int.
 */
public class ToggleBit {
    private int n;
    private int bit;

    public ToggleBit(int n, int bit) {
        this.n = n;
        this.bit = bit;
    }

    public int compute() {
        return n ^ (1 << bit);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test toggleBit():");
        System.out.println("=================");;

        int n = 0;

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = new ToggleBit(n, i).compute();
            TestUtils.printBits(n);
        }
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = new ToggleBit(n, i).compute();
            TestUtils.printBits(n);
        }
    }
}
