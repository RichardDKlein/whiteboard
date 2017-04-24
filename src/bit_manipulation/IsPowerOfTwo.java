package bit_manipulation;

/**
 * Determine whether an int is a power of 2.
 */
public class IsPowerOfTwo {
    private IsPowerOfTwo() {}
    private int n;

    public static boolean decide(int n) {
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
            + (IsPowerOfTwo.decide(n) ? "true" : "false"));

        n = 1;
        TestUtils.printBits(n);
        System.out.println("Is power of 2 = "
            + (IsPowerOfTwo.decide(n) ? "true" : "false"));

        for (int i = 1; i < Integer.SIZE; ++i) {
            n = 0;
            n = SetBit.set(n, i);
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                + (IsPowerOfTwo.decide(n) ? "true" : "false"));
            n = SetBit.set(n, 0);
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                + (IsPowerOfTwo.decide(n) ? "true" : "false"));
        }
    }
}
