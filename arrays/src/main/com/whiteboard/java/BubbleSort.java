package com.whiteboard.java;

public class BubbleSort {
    /**
     * Sort an array using the bubble sort algorithm.
     * Performance is O(n*n).
     *
     * The algorithm is optimized to avoid re-examining
     * the already sorted elements that "sink" to the
     * bottom of the array during each iteration of the
     * bubble sort.
     *
     * @param a The array to sort.
     */
    public static void bubbleSort(int[] a) {
        int lastUnsortedIndex = a.length - 1;
        while (lastUnsortedIndex > 0) {
            boolean swapOccurred = false;
            int lastUnsortedIndexThisIteration = lastUnsortedIndex;
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swapOccurred = true;
                    lastUnsortedIndexThisIteration = i;
                }
            }
            if (!swapOccurred) {
                break;
            }
            lastUnsortedIndex = lastUnsortedIndexThisIteration;
        }
    }
}
