package strings;

import javafx.util.Pair;

import java.util.*;

/**
 * Find the 'k' most frequently occurring strings in a list
 * of strings, along with the number of times they occur.
 */
public class TopKStrings {
    private TopKStrings() {}

    private static class PairComparator implements Comparator<Pair<String, Integer>> {
        @Override
        public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    private static int k_;
    private static PriorityQueue<Pair<String, Integer>> minHeap_;
    private static LinkedList<Pair<String, Integer>> results_;
    private static List<String> strings_;
    private static Map<String, Integer> tally_;

    /**
     * Find the 'k' most frequently occurring strings in a list of
     * strings, along with the number of times they occur.
     *
     * @param strings The list of strings.
     * @param k A small (relative to the length of 'strings') integer.
     * @return The 'k' most frequently occurring strings in 'strings',
     * along with the number of times they occur.
     */
    public static List<Pair<String, Integer>> topKStrings (List<String> strings, int k) {
        initFields(strings, k);
        tallyStrings();
        buildMinHeap();
        extractResults();
        return results_;
    }

    private static void initFields(List<String> strings, int k) {
        strings_ = strings;
        k_ = k;
        minHeap_ = new PriorityQueue<>(k, new PairComparator());
        results_ = new LinkedList<>();
        tally_ = new HashMap<>();
    }

    private static void tallyStrings() {
        for (String string : strings_) {
            if (tally_.containsKey(string)) {
                tally_.replace(string, tally_.get(string) + 1);
            } else {
                tally_.put(string, 1);
            }
        }
    }

    private static void buildMinHeap() {
        int min = -1;
        for (Map.Entry<String, Integer> entry : tally_.entrySet()) {
            if (entry.getValue() >= min) {
                minHeap_.add(new Pair<>(entry.getKey(), entry.getValue()));
                while (minHeap_.size() > k_) {
                    minHeap_.poll();
                }
                min = minHeap_.peek().getValue();
            }
        }
    }

    private static void extractResults() {
        while (!minHeap_.isEmpty()) {
            results_.addFirst(minHeap_.poll());
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test TopKStrings:");
        System.out.println("================");

        String gettysburgAddress =
                "Four score and seven years ago, our fathers brought " +
                        "forth on this continent a new nation, conceived in " +
                        "liberty, and dedicated to the proposition that all " +
                        "men are created equal." +

                        "Now we are engaged in a great civil war, testing whether " +
                        "that nation, or any nation so conceived and so dedicated, " +
                        "can long endure. We are met on a great battlefield of that " +
                        "war. We have come to dedicate a portion of that field, as a " +
                        "final resting place for those who here gave their lives that " +
                        "that nation might live. It is altogether fitting and proper " +
                        "that we should do this." +

                        "But, in a larger sense, we can not dedicate -- we can not " +
                        "consecrate -- we can not hallow -- this ground. The brave " +
                        "men, living and dead, who struggled here have consecreated " +
                        "it, far above our poor power to add or detract. The world " +
                        "will little note, nor long remember, what we say here, but " +
                        "it can never forget what they did here." +

                        "It is for us, the living, rather, to be dedicated here to " +
                        "the unfinished work which they who fought here have thus " +
                        "far so nobly advanced. It is rather for us to be here " +
                        "dedicated to the great task remaining before us -- that from " +
                        "these honored dead we take increased devotion to that cause " +
                        "for which they gave the last full measure of devotion -- that " +
                        "we here highly resolve that these dead shall not have died " +
                        "in vain -- that this nation, under God, shall have a new birth " +
                        "of freedom -- and that government of the people, by the people, " +
                        "for the people, shall not perish from the earth.";

        List<String> strings = parseTextIntoLowerCaseWords(gettysburgAddress);
        //printStrings(strings);
        List<Pair<String, Integer>> topTen = topKStrings(strings, 10);
        System.out.println("Top 10 words in Gettysburg Address:");
        for (int i = 0; i < 10; ++i) {
            System.out.println(i + 1 + ". " + topTen.get(i).getKey() +
                    "\t(" + topTen.get(i).getValue() + " occurrences)");
        }
    }

    private static List<String> parseTextIntoLowerCaseWords(String text) {
        List<String> strings = new ArrayList<>();
        String[] words = text.split("[,.\\- ]+");
        for (String word : words) {
            char firstChar = word.charAt(0);
            if (Character.isUpperCase(firstChar)) {
                word = Character.toLowerCase(firstChar) + word.substring(1);
            }
            strings.add(word);
        }
        return strings;
    }

    private static void printStrings(List<String> strings) {
        System.out.println("strings = {");
        for (String string : strings) {
            System.out.println("\t" + string);
        }
        System.out.println("}");
    }
}
