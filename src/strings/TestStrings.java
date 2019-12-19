package strings;

public final class TestStrings {
    private TestStrings() {}

    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                   STRINGS                   ");
        System.out.println("=============================================");

        FindSubstring.test();
        LongestPalindromicSubstring.test();
        PermutationsOfString.test();
        RansomNote.test();
        ReverseWordsInSentence.test();
        StringsArePermutations.test();
    }
}
