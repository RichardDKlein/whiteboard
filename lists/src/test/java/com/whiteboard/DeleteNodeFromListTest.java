package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DeleteNodeFromListTest {
    private ArrayList<Character> listData = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g'));

    @Test
    void deleteNode() {
        System.out.println();
        System.out.println("Test DeleteNodeFromList:");
        System.out.println("================");

        List<ListNode<Character>> expected = new ArrayList<>();
        expected.add(TestUtils.createList(Arrays.asList('b', 'c', 'd', 'e', 'f', 'g')));
        expected.add(TestUtils.createList(Arrays.asList('a', 'c', 'd', 'e', 'f', 'g')));
        expected.add(TestUtils.createList(Arrays.asList('a', 'b', 'd', 'e', 'f', 'g')));
        expected.add(TestUtils.createList(Arrays.asList('a', 'b', 'c', 'e', 'f', 'g')));
        expected.add(TestUtils.createList(Arrays.asList('a', 'b', 'c', 'd', 'f', 'g')));
        expected.add(TestUtils.createList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'g')));
        expected.add(TestUtils.createList(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g')));

        System.out.println("\nOriginal list:");
        ListNode<Character> list = createTestList();
        TestUtils.printList(list);

        for (int i = 0; i < listData.size(); ++i) {
            System.out.println("\nDeleting Node '" + listData.get(i) + "':");
            list = createTestList();
            ListNode<Character> node = TestUtils.findNode(list, listData.get(i));
            boolean result = DeleteNodeFromList.deleteNodeFromList(node);
            assert(TestUtils.listsAreEqual(list, expected.get(i)));
            assert(result == i < listData.size() - 1);
            TestUtils.printList(list);
            System.out.println(result ? "SUCCESS" : "FAILURE");
        }
    }

    private ListNode<Character> createTestList() {
        return TestUtils.createList(listData);
    }
}
