package com.whiteboard.java;

import java.util.*;

/**
 * Find the 'k' most frequently occurring strings in a list
 * of strings, along with the number of times they occur.
 */
public final class TopKStrings {
    private TopKStrings() {
    }

    private static List<String> strings;
    private static int k;
    private static Map<String, Integer> stringCounts;
    private static PriorityQueue<Map.Entry<String, Integer>> minHeap;

    /**
     * Find the 'k' most frequently occurring strings in a list of
     * strings, along with the number of times they occur.
     *
     * @param strings The list of strings.
     * @param k A small (relative to the length of 'strings') integer.
     * @return The 'k' most frequently occurring strings in 'strings',
     * along with the number of times they occur.
     */
    public static List<Map.Entry<String, Integer>> topKStrings (List<String> strings, int k) {
        saveCallingParams(strings, k);
        countStrings();
        buildMinHeap();
        return extractResultsFromMinHeap();
    }

    private static void saveCallingParams(List<String> strings, int k) {
        TopKStrings.strings = strings;
        TopKStrings.k = k;
    }

    private static void countStrings() {
        stringCounts = new HashMap<>();
        for (String s : strings) {
            int count = stringCounts.getOrDefault(s, 0);
            stringCounts.put(s, count + 1);
        }
    }

    private static void buildMinHeap() {
        minHeap = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
        for (Map.Entry<String, Integer> stringCount : stringCounts.entrySet()) {
            if (minHeap.isEmpty() || minHeap.peek().getValue() <= stringCount.getValue()) {
                minHeap.add(stringCount);
                while (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }
    }

    private static List<Map.Entry<String, Integer>> extractResultsFromMinHeap() {
        LinkedList<Map.Entry<String, Integer>> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll());
        }
        return result;
    }
}
