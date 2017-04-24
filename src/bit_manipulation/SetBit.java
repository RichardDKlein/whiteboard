package bit_manipulation;

/**
 * Set the specified bit in an int.
 */
public class SetBit {
    private SetBit() {}

    public static int set(int n, int bit) {
        return n | (1 << bit);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test setBit():");
        System.out.println("==============");

        int n = 0;
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = SetBit.set(n, i);
            TestUtils.printBits(n);
        }
    }
}
