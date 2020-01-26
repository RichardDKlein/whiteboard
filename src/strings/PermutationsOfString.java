package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all the permutations of a given string.
 */
public final class PermutationsOfString {
    private PermutationsOfString() {}

    /**
     * Find all the permutations of a given string.
     *
     * @param s The string of interest.
     * @return An list containing all the permutations
     * of the given string.
     */
    public static List<String> permutationsOfString(String s) {
        List<String> perms = new ArrayList<>();
        if (s.isEmpty()) {
            perms.add(s);
            return perms;
        }
        char firstChar = s.charAt(0);
        String rem = s.substring(1);
        List<String> remPerms = permutationsOfString(rem);
        for (String remPerm : remPerms) {
            for (int i = 0; i <= remPerm.length(); ++i) {
                String perm = insertCharAt(remPerm, firstChar, i);
                perms.add(perm);
            }
        }
        return perms;
    }

    private static String insertCharAt(String s, char c, int index) {
        return s.substring(0, index) + c + s.substring(index);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test PermutationsOfString:");
        System.out.println("==========================");

        String testString = "abcd";
        List<String> perms = permutationsOfString(testString);
        System.out.println("permutationsOfString(" + "\"" + testString
                + "\") returns " + perms.size() + " permutations:");
        for (String perm : perms) {
            System.out.println("\t\"" + perm + "\"");
        }
    }
}
