package java.com.whiteboard;

/**
 * Given a string consisting of '0's and '1's, find the number of
 * substrings starting and ending with '1'.
 */
public final class SubstringsStartingAndEndingWith1 {
    private SubstringsStartingAndEndingWith1() {
    }

    /**
     * Given a string consisting of '0's and '1's, find the number
     * of substrings starting and ending with '1'.
     *
     * The obvious, brute force solution is O(n * n).
     *
     * We can do better by noting that this is actually a combinatorics
     * problem in disguise.
     *
     * Suppose we constructed a set containing all the indices in the
     * given string at which a '1' appears. Then the problem of determining
     * the number of substrings starting and ending with '1' is identical
     * to the problem of determining the number of ways we can pick two of
     * these indices.
     *
     * That is, we are asked to find the number of combinations of 'n'
     * indices taken 'c' at a time, where 'n' is the total number of
     * indices, i.e. the number of '1's in the string, and 'c' is two.
     *
     * The formula for this is:
     *
     *     n!/[c!(n-c)!] =
     *     n!/[2!(n-2)!] =
     *     [n(n-1)(n-2)!]/[2!(n-2)!] =
     *     [n(n-1)]/2.
     *
     * So we just have to compute 'n', and apply this formula.
     *
     * This solution is O(n).
     */
    public static int substringsStartingAndEndingWith1(String s) {
        int numberOfOnes = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++numberOfOnes;
            }
        }
        return numberOfOnes * (numberOfOnes - 1) / 2;
    }
}
