package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Parse a string containing no whitespace into its
 * constituent words.
 */
public final class ParseStringIntoWords {
    private ParseStringIntoWords() {}

    /**
     * Parse a string containing no whitespace into its
     * constituent words.
     *
     * @param s The string to parse.
     * @param dictionary A dictionary of legal words.
     * @return A list containing the constituent words;
     * or null if the given string cannot be parsed; or
     * an empty list if the given string is empty.
     */
    public static List<String> parseStringIntoWords(
            String s, Set<String> dictionary) {
        List<String> words = new ArrayList<>();
        if (s.isEmpty()) {
            return words;
        }
        for (int i = 0; i < s.length(); ++i) {
            String firstWord = s.substring(0, i + 1);
            if (!dictionary.contains(firstWord)) {
                continue;
            }
            String remainder = s.substring(i + 1);
            List<String> remainderParse =
                    parseStringIntoWords(remainder, dictionary);
            if (remainderParse == null) {
                // We failed to parse the remainder.
                // Let's try a longer first word.
                continue;
            }
            words.add(firstWord);
            words.addAll(remainderParse);
            return words;
        }
        return null;
    }

    public static void test() {
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
        dictionary.add("so");
        dictionary.add("do");
        dictionary.add("dog");
        dictionary.add("dogs");

        String[] testStrings = {
            "nowisthetimeforallgoodmentocometotheaidoftheircountry",
            "nowisthetimeforallgoodxmentocometotheaidoftheircountry",
            "catsruleandsododogs",
            "mxrptlqgaahyutlkjfjiwllvdgirtuwbvsawovmhudtjmnevnorggh"
        };

        for (String s : testStrings) {
            List<String> parseResult = parseStringIntoWords(s, dictionary);
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
