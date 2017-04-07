package bit_manipulation;

/**
 * Determine whether an int is a power of 2.
 */
public class IsPowerOfTwo {
    private int n;

    public IsPowerOfTwo(int n) {
        this.n = n;
    }

    public boolean compute() {
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
                + (new IsPowerOfTwo(n).compute() ? "true" : "false"));

        n = 1;
        TestUtils.printBits(n);
        System.out.println("Is power of 2 = "
                + (new IsPowerOfTwo(n).compute() ? "true" : "false"));

        for (int i = 1; i < Integer.SIZE; ++i) {
            n = 0;
            n = new SetBit(n, i).compute();
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                    + (new IsPowerOfTwo(n).compute() ? "true" : "false"));
            n = new SetBit(n, 0).compute();
            TestUtils.printBits(n);
            System.out.println("Is power of 2 = "
                    + (new IsPowerOfTwo(n).compute() ? "true" : "false"));
        }
    }
}
