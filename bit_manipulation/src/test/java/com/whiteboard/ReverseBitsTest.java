package java.com.whiteboard;

import org.junit.Test;

public class ReverseBitsTest {
    @Test
    public void reverseBitsTest() {
        System.out.println();
        System.out.println("Test ReverseBits:");
        System.out.println("=================");

        int n = 0b10110111011110111110111111010101;

        int expected = 0b10101011111101111101111011101101;

        BitTestUtils.printBits(n);
        n = ReverseBits.reverseBits(n);
        assert(n == expected);
        System.out.print("Reversed:\n");
        BitTestUtils.printBits(n);
    }
}
