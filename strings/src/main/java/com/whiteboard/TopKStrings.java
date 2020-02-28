package com.whiteboard;

import javafx.util.Pair;

import java.util.*;

/**
 * Find the 'k' most frequently occurring strings in a list
 * of strings, along with the number of times they occur.
 */
public class TopKStrings {
    private int k_;
    private PriorityQueue<Pair<String, Integer>> minHeap_;
    private LinkedList<Pair<String, Integer>> results_;
    private List<String> strings_;
    private Map<String, Integer> tally_;

    /**
     * Find the 'k' most frequently occurring strings in a list of
     * strings, along with the number of times they occur.
     *
     * @param strings The list of strings.
     * @param k A small (relative to the length of 'strings') integer.
     * @return The 'k' most frequently occurring strings in 'strings',
     * along with the number of times they occur.
     */
    public List<Pair<String, Integer>> topKStrings (List<String> strings, int k) {
        initFields(strings, k);
        tallyStrings();
        buildMinHeap();
        extractResults();
        return results_;
    }

    private void initFields(List<String> strings, int k) {
        strings_ = strings;
        k_ = k;
        minHeap_ = new PriorityQueue<>(k, new PairComparator());
        results_ = new LinkedList<>();
        tally_ = new HashMap<>();
    }

    private void tallyStrings() {
        for (String string : strings_) {
            if (tally_.containsKey(string)) {
                tally_.replace(string, tally_.get(string) + 1);
            } else {
                tally_.put(string, 1);
            }
        }
    }

    private void buildMinHeap() {
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

    private void extractResults() {
        while (!minHeap_.isEmpty()) {
            results_.addFirst(minHeap_.poll());
        }
    }

    // ===================================================================
    // INNER CLASSES
    // ===================================================================

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
}
