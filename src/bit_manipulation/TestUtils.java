package bit_manipulation;

/**
 * Test utilities for the bit_manipulation package.
 */
public class TestUtils {
    public static void printBits(int n) {
        for (int bit = Integer.SIZE - 1; bit >= 0; --bit) {
            int bitVal = new GetBit(n, bit).compute();
            System.out.print(bitVal);
        }
        System.out.println();
    }
}
