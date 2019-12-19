package bit_manipulation;

/**
 * Test utilities for the bit_manipulation package.
 */
public final class TestUtils {
    private TestUtils() {}

    static void printBits(int n) {
        for (int bit = Integer.SIZE - 1; bit >= 0; --bit) {
            int bitVal = GetBit.getBit(n, bit);
            System.out.print(bitVal);
        }
        System.out.println();
    }
}
