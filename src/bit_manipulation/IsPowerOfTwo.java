package bit_manipulation;

/**
 * Is an int a power of 2?
 */
public class IsPowerOfTwo {
    private IsPowerOfTwo() {}

    /**
     * Determine whether an int is a power of 2.
     *
     * @param n The int of interest.
     * @return A boolean indicating whether ('true')
     * or not ('false') the given int is a power of 2.
     */
    public static boolean isPowerOfTwo(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test isPowerOfTwo():");
        System.out.println("====================");

        int n;

        n = 0;
        TestUtils.printBits(n);
        System.out.println("Is power of 2 = "
            + (IsPowerOfTwo.isPowerOfTwo(n) ? "true" : "false"));

        n = 1;
        TestUtils.printBits(n);
        System.out.println("Is power of 2 = "
            + (IsPowerOfTwo.isPowerOfTwo(n) ? "true" : "false"));

        for (int i = 1; i < Integer.SIZE; ++i) {
            n = 0;
            n = SetBit.setBit(n, i);
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                + (IsPowerOfTwo.isPowerOfTwo(n) ? "true" : "false"));
            n = SetBit.setBit(n, 0);
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                + (IsPowerOfTwo.isPowerOfTwo(n) ? "true" : "false"));
        }
    }
}
