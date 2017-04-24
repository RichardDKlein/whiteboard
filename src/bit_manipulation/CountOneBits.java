package bit_manipulation;

/**
 * Count the number of '1' bits in an int.
 */
public class CountOneBits {
    private CountOneBits() {}

    public static int count(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            ++count;
        }
        return count;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test countOneBits():");
        System.out.println("====================");

        int n = 0;

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggle(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                CountOneBits.count(n));
        }

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggle(n, i);
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                CountOneBits.count(n));
        }
    }
}
