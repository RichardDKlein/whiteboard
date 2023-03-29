package com.whiteboard;

/**
 * Reverse the words in a sentence.
 */
public final class ReverseWordsInSentence {
    private ReverseWordsInSentence() {
    }

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
            int iStartOfNextWord = startOfNextWord(buf, i);
            if (iStartOfNextWord < 0) {
                break;
            }
            int iEndOfNextWord = endOfCurrentWord(buf, iStartOfNextWord);
            reverseWord(buf, iStartOfNextWord, iEndOfNextWord);
            i = iEndOfNextWord + 1;
        }
        return new String(buf);
    }

    private static int startOfNextWord(char[] buf, int startingIndex) {
        for (int i = startingIndex; i < buf.length; ++i) {
            if (!Character.isWhitespace(buf[i])) {
                return i;
            }
        }
        return -1;
    }

    private static int endOfCurrentWord(char[] buf, int startingIndex) {
        for (int i = startingIndex; i < buf.length; ++i) {
            if (Character.isWhitespace(buf[i])) {
                return i - 1;
            }
        }
        return buf.length - 1;
    }

    private static void reverseWord(char[] buf, int iStartOfWord, int iEndOfWord) {
        int left = iStartOfWord;
        int right = iEndOfWord;
        while (left < right) {
            char tmp = buf[left];
            buf[left] = buf[right];
            buf[right] = tmp;
            ++left;
            --right;
        }
    }
}
