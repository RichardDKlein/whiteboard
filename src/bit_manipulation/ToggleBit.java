package bit_manipulation;

/**
 * Toggle bit.
 */
public class ToggleBit {
    private ToggleBit() {}

    /**
     * Toggle the specified bit in an int.
     *
     * @param n The int of interest.
     * @param bit The bit to toggle (where 0 = LSB).
     * @return A copy of the int, but with the
     * specified bit toggled.
     */
    public static int toggleBit(int n, int bit) {
        return n ^ (1 << bit);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ToggleBit:");
        System.out.println("===============");;

        int n = 0;

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = toggleBit(n, i);
            TestUtils.printBits(n);
        }
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = toggleBit(n, i);
            TestUtils.printBits(n);
        }
    }
}
