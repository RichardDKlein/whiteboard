package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RemoveDupsFromListTest {

    @Test
    void removeDupsFromList() {
        System.out.println();
        System.out.println("Test RemoveDupsFromList:");
        System.out.println("========================");

        ListNode<Character> listWithDups = TestUtils.createList(new ArrayList<>(
                Arrays.asList('a','b','c','a','d','e','b','f','d','g','c','e','g')));

        ListNode<Character> listWithoutDups = TestUtils.createList(new ArrayList<>(
                Arrays.asList('a','b','c','d','e','f','g')));

        TestUtils.printList(listWithDups);
        System.out.println("Removing duplicates:");
        RemoveDupsFromList.removeDupsFromList(listWithDups);
        assert(TestUtils.listsAreEqual(listWithDups, listWithoutDups));
        TestUtils.printList(listWithDups);
    }
}
