package java.com.whiteboard;

import org.junit.Test;

public class BitDiffTest {
    @Test
    public void bitDiffTest() {
        System.out.println();
        System.out.println("Test BitDiff:");
        System.out.println("=============");

        int m = 0xAAAAAAAA;
        int n = 0xAAABAACA;

        int expected = 3;

        BitTestUtils.printBits(m);
        BitTestUtils.printBits(n);
        int bitDiff = BitDiff.bitDiff(m, n);
        assert(bitDiff == expected);
        System.out.println("Bit diff = " + bitDiff);
    }
}
