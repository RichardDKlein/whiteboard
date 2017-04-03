package bit_manipulation;

/**
 * Count the number of '1' bits in an int.
 */
public class CountOneBits {
    private int n_;
    public CountOneBits(int n) {
        n_ = n;
    }

    public int compute() {
        int count = 0;
        while (n_ != 0) {
            n_ &= n_ - 1;
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
            n = new ToggleBit(n, i).compute();
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                    new CountOneBits(n).compute());
        }

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = new ToggleBit(n, i).compute();
            TestUtils.printBits(n);
            System.out.println("Number of 1 bits = " +
                    new CountOneBits(n).compute());
        }
    }
}
