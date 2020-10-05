package com.whiteboard;

import java.util.*;

/**
 * Find the 'k' most frequently occurring strings in a list
 * of strings, along with the number of times they occur.
 */
public final class TopKStrings {
    private TopKStrings() {
    }

    private static class MapEntryComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    }

    private static List<String> strings;
    private static int k;
    private static final Map<String, Integer> stringCounts = new HashMap<>();
    private static final PriorityQueue<Map.Entry<String, Integer>> minHeap =
            new PriorityQueue<>(new MapEntryComparator());

    /**
     * Find the 'k' most frequently occurring strings in a list of
     * strings, along with the number of times they occur.
     *
     * @param strings The list of strings.
     * @param k A small (relative to the length of 'strings') integer.
     * @return The 'k' most frequently occurring strings in 'strings',
     * along with the number of times they occur.
     */
    public static List<Map.Entry<String, Integer>>
    topKStrings (
            List<String> strings,
            int k) {

        TopKStrings.strings = strings;
        TopKStrings.k = k;

        countStrings();
        buildMinHeap();
        return extractResults();
    }

    private static void countStrings() {
        for (String string : strings) {
            Integer count = stringCounts.get(string);
            if (count == null) {
                stringCounts.put(string, 1);
            } else {
                stringCounts.replace(string, count + 1);
            }
        }
    }

    private static void buildMinHeap() {
        int min = -1;
        for (Map.Entry<String, Integer> entry : stringCounts.entrySet()) {
            if (entry.getValue() >= min) {
                minHeap.add(entry);
                while (minHeap.size() > k) {
                    minHeap.poll();
                }
                min = minHeap.peek().getValue();
            }
        }
    }

    private static List<Map.Entry<String, Integer>> extractResults() {
        LinkedList<Map.Entry<String, Integer>> results = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            results.addFirst(minHeap.poll());
        }
        return results;
    }
}
