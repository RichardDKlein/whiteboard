package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        ParseStringIntoWords instance = new ParseStringIntoWords();

        for (String s : testStrings) {
            List<String> parseResult = instance.parseStringIntoWords(s, dictionary);
            System.out.println("parseStringIntoWords(\"" + s + "\"):");
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
