package com.whiteboard;

import com.sun.tools.javac.util.Pair;

import java.util.*;

/**
 * Find the 'k' most frequently occurring strings in a list
 * of strings, along with the number of times they occur.
 */
public class TopKStrings {
    private List<String> strings_;
    private int k_;
    private Map<String, Integer> stringCount_ = new HashMap<>();
    private PriorityQueue<Pair<String, Integer>> minHeap_ =
            new PriorityQueue<>(new PairComparator());

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
        strings_ = strings;
        k_ = k;
        countStrings();
        buildMinHeap();
        return extractResults();
    }

    private void countStrings() {
        for (String string : strings_) {
            if (stringCount_.containsKey(string)) {
                stringCount_.replace(string, stringCount_.get(string) + 1);
            } else {
                stringCount_.put(string, 1);
            }
        }
    }

    private void buildMinHeap() {
        int min = -1;
        for (Map.Entry<String, Integer> entry : stringCount_.entrySet()) {
            if (entry.getValue() >= min) {
                minHeap_.add(new Pair<>(entry.getKey(), entry.getValue()));
                while (minHeap_.size() > k_) {
                    minHeap_.poll();
                }
                min = minHeap_.peek().snd;
            }
        }
    }

    private List<Pair<String, Integer>> extractResults() {
        LinkedList<Pair<String, Integer>> results = new LinkedList<>();
        while (!minHeap_.isEmpty()) {
            results.addFirst(minHeap_.poll());
        }
        return results;
    }

    // ===================================================================
    // INNER CLASSES
    // ===================================================================

    private static class PairComparator implements
            Comparator<Pair<String, Integer>> {
        @Override
        public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
            return o1.snd - o2.snd;
        }
    }
}
