package com.whiteboard;

import org.junit.jupiter.api.Test;

class ReverseWordsInSentenceTest {
    @Test
    void reverseWordsInSentence() {
        System.out.println();
        System.out.println("Test ReverseWordsInSentence:");
        System.out.println("============================");

        String[] testSentences = {
                "Now is the time",
                " for all good men   ",
                "to come to the aid of their country."
        };

        ReverseWordsInSentence instance = new ReverseWordsInSentence();

        for (String sentence : testSentences) {
            String reverse = instance.reverseWordsInSentence(sentence);
            System.out.println("reverseWordsInSentence(\"" + sentence
                    + "\") = \"" + reverse + "\"");
        }
    }
}
