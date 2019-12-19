package bit_manipulation;

public final class TestBitManipulation {
    private TestBitManipulation() {}

    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("               BIT MANIPULATION              ");
        System.out.println("=============================================");

        BitDiff.test();
        ClearBit.test();
        CountOneBits.test();
        GetBit.test();
        InsertBits.test();
        IsPowerOfTwo.test();
        ReverseBits.test();
        SetBit.test();
        ToggleBit.test();
    }
}
