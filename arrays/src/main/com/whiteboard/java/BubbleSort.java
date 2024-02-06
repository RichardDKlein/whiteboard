package com.whiteboard.java;

/**
 * Sort an array using the bubble sort algorithm.
 */
public final class BubbleSort {
    private BubbleSort() {
    }

    /**
     * Sort an array using the bubble sort algorithm.
     * Performance is O(n*n).
     *
     * @param a The array to sort.
     */
    public static void bubbleSort(int[] a) {
        while (true) {
            boolean swapOccurred = false;
            for (int i = 0; i < a.length - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swapOccurred = true;
                }
            }
            if (!swapOccurred) {
                return;
            }
        }
    }
}
