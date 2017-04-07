package bit_manipulation;

/**
 * Set the specified bit in an int.
 */
public class SetBit {
    private int n;
    private int bit;

    public SetBit(int n, int bit) {
        this.n = n;
        this.bit = bit;
    }

    public int compute() {
        return n | (1 << bit);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test setBit():");
        System.out.println("==============");

        int n = 0;
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = new SetBit(n, i).compute();
            TestUtils.printBits(n);
        }
    }
}
