package com.whiteboard.java;

import java.util.*;

public final class TopKStrings {
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
        Map<String, Integer> stringCounts = countStrings(strings);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = buildMinHeap(stringCounts, k);
        return extractTopKStringsFromMinHeap(minHeap);
    }

    private static Map<String, Integer> countStrings(List<String> strings) {
        Map<String, Integer> stringCounts = new HashMap<>();
        for (String string : strings) {
            int count = stringCounts.getOrDefault(string, 0);
            stringCounts.put(string, count + 1);
        }
        return stringCounts;
    }

    private static PriorityQueue<Map.Entry<String, Integer>>
    buildMinHeap(Map<String, Integer> stringCounts, int k) {
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
        for (Map.Entry<String, Integer> stringCount : stringCounts.entrySet()) {
            if (minHeap.isEmpty() || minHeap.peek().getValue() <= stringCount.getValue()) {
                minHeap.add(stringCount);
                while (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }
        return minHeap;
    }

    private static List<Map.Entry<String, Integer>>
    extractTopKStringsFromMinHeap(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        List<Map.Entry<String, Integer>> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll());
        }
        return result;
    }
}
