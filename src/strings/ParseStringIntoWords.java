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
    public static class ParseResult {
        public boolean success_;
        public List<String> words_;

        public ParseResult(boolean success, List<String> words) {
            success_ = success;
            words_ = words;
        }
    }

    private static final List<String> EMPTY_WORD_LIST =
            new ArrayList<>();
    private static final ParseResult FAILURE =
            new ParseResult(false, EMPTY_WORD_LIST);
    private static final ParseResult SUCCESS_EMPTY_STRING =
            new ParseResult(true, EMPTY_WORD_LIST);

    private ParseStringIntoWords() {}

    /**
     * Parse a string containing no whitespace into its
     * constituent words.
     *
     * @param s The string to parse.
     * @param dictionary A dictionary of legal words.
     * @return A data structure containing: (1) A flag
     * indicating whether the parse was successful, and
     * if so, (2) A list containing the constituent words.
     */
    public static ParseResult parseStringIntoWords(
            String s, Set<String> dictionary) {
        List<String> words = new ArrayList<>();
        if (s.isEmpty()) {
            return SUCCESS_EMPTY_STRING;
        }
        for (int i = 0; i < (int)s.length(); ++i) {
            String firstWord = s.substring(0, i + 1);
            if (!dictionary.contains(firstWord)) {
                continue;
            }
            String remainder = s.substring(i + 1);
            ParseResult remainderParse =
                    parseStringIntoWords(remainder, dictionary);
            if (!remainderParse.success_) {
                continue;
            }
            words.add(firstWord);
            for (String word : remainderParse.words_) {
                words.add(word);
            }
            return new ParseResult(true, words);
        }
        return FAILURE;
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
            "catsruleandsododogs"
        };

        for (String s : testStrings) {
            ParseResult parseResult = parseStringIntoWords(s, dictionary);
            System.out.println("parseStringIntoWords(\"" + s + "\"):");
            System.out.println("{");
            for (String word : parseResult.words_) {
                System.out.println("\t\"" + word + "\"");
            }
            System.out.println("}");
        }
    }
 }
