package strings;

import java.util.Arrays;

/**
 * Determine whether two strings are permutations of each other.
 */
public class StringsArePermutations {
    private StringsArePermutations() {
    }

    /**
     * Determine whether two strings are permulations of each other.
     *
     * @param s1 One of the strings.
     * @param s2 The other string.
     * @return A boolean indicating whether ('true) or not ('false')
     * s1 and s2 are permutations of each other.
     */
    public static boolean stringsArePermutations(String s1, String s2) {
        return sortString(s1).equals(sortString(s2));
    }

    private static String sortString(String s) {
        char[] buf = s.toCharArray();
        Arrays.sort(buf);
        return new String(buf);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test StringsArePermutations:");
        System.out.println("============================");

        String[] testStrings = {
            "Hello, world",
            "Hello, world!",
            "!dlrow ,olleH",
            "!dlroW ,olleH",
            "aabbb",
            "aaabb"
        };

        for (int i = 0; i < testStrings.length; ++i) {
            for (int j = i; j < testStrings.length; ++j) {
                String s1 = testStrings[i];
                String s2 = testStrings[j];
                boolean p = stringsArePermutations(s1, s2);
                System.out.println("stringsArePermutations(\""
                        + s1 + "\", \"" + s2 + "\") = " + p);
            }
        }
    }
}
