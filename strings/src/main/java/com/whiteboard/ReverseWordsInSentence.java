package com.whiteboard;

/**
 * Reverse the words in a sentence.
 */
public class ReverseWordsInSentence {
    /**
     * Reverse the words in a sentence.
     *
     * @param sentence The sentence whose words are to be reversed.
     * @return A copy of the given sentence, but with the words
     * reversed.
     */
    public String reverseWordsInSentence(String sentence) {
        char[] buf = sentence.toCharArray();
        int i = 0;
        while (i < buf.length) {
            int iStartNextWord = findStartOfNextWord(buf, i);
            if (iStartNextWord < 0) {
                break;
            }
            int iEndNextWord = findEndOfNextWord(buf, iStartNextWord);
            reverseWord(buf, iStartNextWord, iEndNextWord);
            i = iEndNextWord + 1;
        }
        return new String(buf);
    }

    private int findStartOfNextWord(char[] buf, int i) {
        while (i < buf.length) {
            if (Character.isAlphabetic(buf[i])) {
                return i;
            } else {
                ++i;
            }
        }
        return -1;
    }

    private int findEndOfNextWord(char[] buf, int i) {
        while (i < buf.length) {
            if (!Character.isAlphabetic(buf[i])) {
                return i - 1;
            } else {
                ++i;
            }
        }
        return buf.length - 1;
    }

    void reverseWord(char[] buf, int iStartWord, int iEndWord) {
        int left = iStartWord;
        int right = iEndWord;
        while (left < right) {
            char tmp = buf[left];
            buf[left] = buf[right];
            buf[right] = tmp;
            ++left;
            --right;
        }
    }
}
