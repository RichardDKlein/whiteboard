package com.whiteboard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ShuffleListTest {

    @Test
    void shuffleList() {
        final int NUM_CARDS = 52;

        System.out.println();
        System.out.println("Test ShuffleList:");
        System.out.println("==================");

        List<Integer> unshuffledList = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS; ++i) {
            unshuffledList.add(i);
        }
        List<Integer> shuffledList = new ArrayList<>(unshuffledList);

        System.out.println("Unshuffled list = " + Arrays.toString(unshuffledList.toArray()));
        ShuffleList<Integer> instance = new ShuffleList<>();
        for (int i = 0; i < 10; i++) {
            instance.shuffleList(shuffledList);
            List<Integer> sortedShuffledList = new ArrayList<>(shuffledList);
            Collections.sort(sortedShuffledList);
            assert(sortedShuffledList.equals(unshuffledList));
            System.out.println("Shuffled   list = " + Arrays.toString(shuffledList.toArray()));
        }
    }
}
