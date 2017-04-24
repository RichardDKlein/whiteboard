package bit_manipulation;

/**
 * Get the value (0 or 1) of the specified bit (where 0 = LSB) in an int.
 */
public class GetBit {
    private GetBit() {}

    public static int get(int n, int bit) {
        return (n & (1 << bit)) == 0 ? 0 : 1;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test getBit():");
        System.out.println("==============");

        int n = 0xAAAAAAAA;
        TestUtils.printBits(n);
        for (int i = 0; i < Integer.SIZE; ++i) {
            System.out.println("Bit " + i + " = " + GetBit.get(n, i));
        }
    }
}
