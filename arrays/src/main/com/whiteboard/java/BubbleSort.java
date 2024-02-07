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
     * @param a The array to be sorted. It will be sorted
     *          in place.
     */
    public static void bubbleSort(int[] a) {
        boolean swapOccurred;
        int numberOfUnsortedElements = a.length;
        do {
            swapOccurred = false;
            int newNumberOfUnsortedElements = 0;
            for (int i = 0; i < numberOfUnsortedElements - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swapOccurred = true;
                    newNumberOfUnsortedElements = i + 1;
                }
            }
            numberOfUnsortedElements = newNumberOfUnsortedElements;
        } while (swapOccurred);
    }
}
