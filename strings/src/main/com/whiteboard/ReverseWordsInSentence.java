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
            int startOfNextWord = findStartOfNextWord(buf, i);
            if (startOfNextWord < 0) {
                break;
            }
            int endOfNextWord = findEndOfCurrentWord(buf, startOfNextWord);
            reverseWord(buf, startOfNextWord, endOfNextWord);
            i = endOfNextWord + 1;
        }
        return new String(buf);
    }

    private static int findStartOfNextWord(char[] buf, int startingIndex) {
        for (int i = startingIndex; i < buf.length; ++i) {
            if (!Character.isWhitespace(buf[i])) {
                return i;
            }
        }
        return -1;
    }

    private static int findEndOfCurrentWord(char[] buf, int startingIndex) {
        for (int i = startingIndex; i < buf.length; ++i) {
            if (Character.isWhitespace(buf[i])) {
                return i - 1;
            }
        }
        return buf.length - 1;
    }

    private static void reverseWord(char[] buf, int startOfWord, int endOfWord) {
        int left = startOfWord;
        int right = endOfWord;
        while (left < right) {
            char tmp = buf[left];
            buf[left] = buf[right];
            buf[right] = tmp;
            ++left;
            --right;
        }
    }
}
