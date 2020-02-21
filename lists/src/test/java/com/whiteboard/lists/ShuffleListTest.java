package com.whiteboard.lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ShuffleListTest {

    @Test
    void shuffleList() {
        final int NUM_CARDS = 52;

        System.out.println();
        System.out.println("Test ShuffleList:");
        System.out.println("==================");

        List<Integer> deck = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS; ++i) {
            deck.add(i);
        }

        System.out.println("Unshuffled deck = " + Arrays.toString(deck.toArray()));
        ShuffleList<Integer> instance = new ShuffleList<>();
        for (int i = 0; i < 10; i++) {
            instance.shuffleList(deck);
            System.out.println("Shuffled   deck = " + Arrays.toString(deck.toArray()));
        }
    }
}
