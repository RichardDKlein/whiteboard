package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReverseListTest {
    @Test
    void reverseListIterative() {
        System.out.println();
        System.out.println("Test ReverseList:");
        System.out.println("==========================");

        List<ListNode<Character>> lists = new ArrayList<>();
        lists.add(null);
        lists.add(new ListNode<>('a'));
        lists.add(TestUtils.createList(Arrays.asList('a','b','c','d','e','f','g')));

        List<ListNode<Character>> expected = new ArrayList<>();
        expected.add(null);
        expected.add(new ListNode<>('a'));
        expected.add(TestUtils.createList(Arrays.asList('g','f','e','d','c','b','a')));

        for (int i = 0; i < lists.size(); ++i) {
            if (i > 0) {
                System.out.println();
            }
            System.out.println("Original list:");
            TestUtils.printList(lists.get(i));
            ListNode<Character> reversedList = ReverseList.reverseList(lists.get(i));
            assert(TestUtils.listsAreEqual(reversedList, expected.get(i)));
            System.out.println("Reversed list:");
            TestUtils.printList(reversedList);
        }
    }
}
