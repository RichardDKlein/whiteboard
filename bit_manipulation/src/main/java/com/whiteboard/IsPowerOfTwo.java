package java.com.whiteboard;

/**
 * Is an int a power of 2?
 */
public final class IsPowerOfTwo {
    private IsPowerOfTwo() {
    }

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
}
