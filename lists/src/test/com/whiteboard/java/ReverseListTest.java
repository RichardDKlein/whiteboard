package com.whiteboard.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseListTest {
    @Test
    public void reverseListTest() {
        System.out.println();
        System.out.println("Test ReverseList:");
        System.out.println("==========================");

        List<ListNode<Character>> lists = new ArrayList<>();
        lists.add(null);
        lists.add(new ListNode<>('a'));
        lists.add(ListTestUtils.createList(Arrays.asList('a','b','c','d','e','f','g')));

        List<ListNode<Character>> expected = new ArrayList<>();
        expected.add(null);
        expected.add(new ListNode<>('a'));
        expected.add(ListTestUtils.createList(Arrays.asList('g','f','e','d','c','b','a')));

        for (int i = 0; i < lists.size(); ++i) {
            if (i > 0) {
                System.out.println();
            }
            System.out.println("Original list:");
            ListTestUtils.printList(lists.get(i));
            ListNode<Character> reversedList = ReverseList.reverseList(lists.get(i));
            assert(ListTestUtils.listsAreEqual(reversedList, expected.get(i)));
            System.out.println("Reversed list:");
            ListTestUtils.printList(reversedList);
        }
    }
}
