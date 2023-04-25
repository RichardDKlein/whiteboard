package com.whiteboard.java;

import java.util.List;

/**
 * Shuffle a list.
 */
public final class ShuffleList {
    private ShuffleList() {
    }

    /**
     * Shuffle a list, as if it represented a deck of card.
     *
     * Algorithm: Iterate thru the list, swapping each element
     * with an element randomly chosen from the list elements
     * not yet visited.
     *
     * Running time: O(n)
     *
     * @param list The list to be shuffled.
     */
    public static <E> void shuffleList(List<E> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            int j = randomIntegerInInterval(i + 1, list.size() - 1);
            swapElements(list, i, j);
        }
    }

    private static int randomIntegerInInterval(int start, int end) {
        int scaleFactor = end - start;
        int offset = start;
        return (int)Math.round(Math.random() * scaleFactor + offset);
    }

    private static <E> void swapElements(List<E> list, int i, int j) {
        E tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
