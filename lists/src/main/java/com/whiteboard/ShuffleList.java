package com.whiteboard;

import java.util.List;

/**
 * ShuffleList a list.
 */
public class ShuffleList<E> {
    /**
     * ShuffleList a list, as if it represented a deck of card.
     *
     * Algorithm: Iterate thru the list, swapping each element
     * with an element randomly chosen from the list elements
     * not yet visited.
     *
     * Running time: O(n)
     *
     * @param list The list to be shuffled.
     */
    public void shuffleList(List<E> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            int j = randomInInterval(i + 1, list.size() - 1);
            swapElements(list, i, j);
        }
    }

    static int randomInInterval(int min, int max) {
        return (int)Math.round((max - min) * Math.random() + min);
    }

    void swapElements(List<E> list, int i, int j) {
        E tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
