package strings;

/**
 * Find a specified substring in a string.
 */
public final class FindSubstring {
    private FindSubstring() {}

    /**
     * Find a specified substring in a string.
     *
     * @param string The string to search.
     * @param substring The substring to find.
     * @return The index of the specified substring in the specified
     * string, or -1 if the substring cannot be found.
     */
    public static int findSubstring(String string, String substring) {
        char firstCharOfSubstring = substring.charAt(0);
        for (int i = 0; i <= string.length() - substring.length(); ++i) {
            if (string.charAt(i) == firstCharOfSubstring) {
                boolean found = true;
                for (int j = 1; j < substring.length(); ++j) {
                    if (string.charAt(i + j) != substring.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test FindSubstring:");
        System.out.println("===================");

        String testString = "alfalfa romeo";
        String[] testSubstrings = {
            "alfa",
            "rome",
            "alfa romeo",
            "alfa romeos",
            "alfalfa romeo",
            "alfalfa romeos",
            "x"
        };

        System.out.println("Test string = " + testString);
        for (String s : testSubstrings) {
            int index = findSubstring(testString, s);
            System.out.println("findSubstring(" + s + ") = " + index);
        }
    }
}
