package strings;

/**
 * Find the longest palindromic substring of a given string,
 * i.e. the longest substring that is a palindrome.
 */
public class LongestPalindromicSubstring {
    private LongestPalindromicSubstring() {}

    /**
     * Represents a closed interval [min, max] of integers.
     */
    private static class Interval {
        public int min;
        public int max;

        Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }
        int length() {
            return max - min + 1;
        }
        boolean valid() {
            return (min >= 0) && (max >= 0) && (min <= max);
        }
    }

    /**
     * Find the longest palindromic substring of a given string,
     * i.e. the longest substring that is a palindrome.
     *
     * @param s The string of interest.
     * @return The longest palindromic substring.
     */
    public static String longestPalindromicSubstring(String s) {
        Interval longest = new Interval(0, 0);
        for (int i = 0; i < s.length(); ++i) {
            Interval longestOdd = longestAtCenter(s, i, true);
            Interval longestEven = longestAtCenter(s, i, false);
            if (longestOdd.valid() && longestOdd.length() > longest.length()) {
                longest = longestOdd;
            }
            if (longestEven.valid() && longestEven.length() > longest.length()) {
                longest = longestEven;
            }
        }
        return s.substring(longest.min, longest.max + 1);
    }

    private static Interval longestAtCenter(String s, int center, boolean lengthIsOdd) {
        Interval longest = new Interval(-1, -1);
        int left = lengthIsOdd ? center - 1 : center;
        int right = center + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            longest = new Interval(left--, right++);
        }
        return longest;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test LongestPalindromicSubstring:");
        System.out.println("=================================");

        String[] testStrings = {
            "Now is the time",
            "This is a PalindromeWithOddLengthtgneLddOhtiWemordnilaP, correct?",
            "This is a PalindromeWithEvenLengthhtgneLnevEhtiWemordnilaP, correct?",
            "able was i ere i saw elba"
        };

        for (String testString : testStrings) {
            String longest = longestPalindromicSubstring(testString);
            System.out.println("longestPalindromicSubstring(\""
                    + testString + "\") = \"" + longest + "\"");
        }
    }
}
