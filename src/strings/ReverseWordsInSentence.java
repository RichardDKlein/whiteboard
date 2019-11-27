package strings;

/**
 * Reverse the words in a sentence.
 */
public class ReverseWordsInSentence {
    private ReverseWordsInSentence() {}

    /**
     * Reverse the words in a sentence.
     *
     * @param sentence The sentence whose words are to be reversed.
     * @return A copy of the given sentence, but with the words
     * reversed.
     */
    public static String reverseWordsInSentence(String sentence) {
        char[] buf = sentence.toCharArray();
        int i = 0;
        while (i < buf.length) {
            int iStartWord = findStartOfNextWord(buf, i);
            if (iStartWord < 0) {
                break;
            }
            int iEndWord = findEndOfNextWord(buf, iStartWord);
            reverseWord(buf, iStartWord, iEndWord);
            i = iEndWord + 1;
        }
        return new String(buf);
    }

    private static int findStartOfNextWord(char[] buf, int i) {
        while (i < buf.length) {
            if (Character.isAlphabetic(buf[i])) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    private static int findEndOfNextWord(char[] buf, int i) {
        while (i < buf.length) {
            if (!Character.isAlphabetic(buf[i])) {
                return i - 1;
            }
            ++i;
        }
        return buf.length - 1;
    }

    private static void reverseWord(char[] buf, int iStartWord, int iEndWord) {
        int iLeft = iStartWord;
        int iRight = iEndWord;
        while (iLeft < iRight) {
            char tmp = buf[iLeft];
            buf[iLeft] = buf[iRight];
            buf[iRight] = tmp;
            ++iLeft;
            --iRight;
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ReverseWordsInSentence:");
        System.out.println("============================");

        String[] testSentences = {
            "Now is the time",
            " for all good men   ",
            "to come to the aid of their country."
        };

        for (String sentence : testSentences) {
            String reverse = reverseWordsInSentence(sentence);
            System.out.println("reverseWordsInSentence(\"" + sentence
                    + "\") = \"" + reverse + "\"");
        }
    }
}
