package com.whiteboard.java;

import org.junit.Test;

public class ReverseWordsInSentenceTest {
    @Test
    public void reverseWordsInSentenceTest() {
        System.out.println();
        System.out.println("Test ReverseWordsInSentence:");
        System.out.println("============================");

        String[] testSentences = {
                "Now is the time",
                " for all good men   ",
                "to come to the aid of their country."
        };

        String[] expected = {
                "woN si eht emit",
                " rof lla doog nem   ",
                "ot emoc ot eht dia fo rieht .yrtnuoc"
        };

        for (int i = 0; i < testSentences.length; ++i) {
            String reverse = ReverseWordsInSentence.
                    reverseWordsInSentence(testSentences[i]);
            assert(reverse.equals(expected[i]));
            System.out.println("reverseWordsInSentence(\"" + testSentences[i]
                    + "\") = \"" + reverse + "\"");
        }
    }
}
