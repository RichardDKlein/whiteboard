package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.*;

class ParseStringIntoWordsTest {
    @Test
    void parseStringIntoWords() {
        System.out.println();
        System.out.println("Test ParseStringIntoWords:");
        System.out.println("==========================");

        Set<String> dictionary = new HashSet<>();

        dictionary.add("now");
        dictionary.add("is");
        dictionary.add("the");
        dictionary.add("time");
        dictionary.add("for");
        dictionary.add("all");
        dictionary.add("good");
        dictionary.add("men");
        dictionary.add("to");
        dictionary.add("come");
        dictionary.add("aid");
        dictionary.add("of");
        dictionary.add("their");
        dictionary.add("country");

        dictionary.add("cat");
        dictionary.add("cats");
        dictionary.add("rule");
        dictionary.add("and");
        dictionary.add("lean");
        dictionary.add("so");
        dictionary.add("do");
        dictionary.add("sod");
        dictionary.add("dodo");
        dictionary.add("dog");
        dictionary.add("dogs");

        String[] testStrings = {
                "nowisthetimeforallgoodmentocometotheaidoftheircountry",
                "nowisthetimeforallgoodxmentocometotheaidoftheircountry",
                "catsruleandsododogs",
                "mxrptlqgaahyutlkjfjiwllvdgirtuwbvsawovmhudtjmnevnorggh"
        };

        List<List<String>> expected = new ArrayList<>(testStrings.length);

        expected.add(new ArrayList<>(Arrays.asList(
                "now",
                "is",
                "the",
                "time",
                "for",
                "all",
                "good",
                "men",
                "to",
                "come",
                "to",
                "the",
                "aid",
                "of",
                "their",
                "country")));

        expected.add(null);

        expected.add(new ArrayList<>(Arrays.asList(
                "cats",
                "rule",
                "and",
                "so",
                "do",
                "dogs")));

        expected.add(null);

        for (int i = 0; i < testStrings.length; ++i) {
            List<String> parseResult = ParseStringIntoWords.
                    parseStringIntoWords(testStrings[i], dictionary);
            if (parseResult == null) {
                assert(expected.get(i) == null);
            } else {
                assert (parseResult.equals(expected.get(i)));
            }
            System.out.println("parseStringIntoWords(\"" +
                    testStrings[i] + "\"):");
            System.out.println("{");
            if (parseResult == null) {
                System.out.println("\t<cannot parse>\n}");
                continue;
            }
            for (String word : parseResult) {
                System.out.println("\t\"" + word + "\"");
            }
            System.out.println("}");
        }
    }
}
