package java.com.whiteboard;

/**
 * Toggle bit.
 */
public final class ToggleBit {
    private ToggleBit() {
    }

    /**
     * Toggle the specified bit in an int.
     *
     * @param n The int of interest.
     * @param bit The bit to toggle (where 0 = LSB).
     * @return A copy of the int, but with the
     * specified bit toggled.
     */
    public static int toggleBit(int n, int bit) {
        return n ^ (1 << bit);
    }
}
