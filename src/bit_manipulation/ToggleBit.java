package bit_manipulation;

/**
 * Toggle the specified bit (where 0 = LSB) in an int.
 */
public class ToggleBit {
    private ToggleBit() {}

    public static int toggle(int n, int bit) {
        return n ^ (1 << bit);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test toggleBit():");
        System.out.println("=================");;

        int n = 0;

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggle(n, i);
            TestUtils.printBits(n);
        }
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggle(n, i);
            TestUtils.printBits(n);
        }
    }
}
