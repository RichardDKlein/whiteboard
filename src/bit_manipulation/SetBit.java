package bit_manipulation;

/**
 * Set the specified bit in an int.
 */
public class SetBit {
    private int n_;
    private int bit_;

    public SetBit(int n, int bit) {
        n_ = n;
        bit_ = bit;
    }

    public int compute() {
        return n_ | (1 << bit_);
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
