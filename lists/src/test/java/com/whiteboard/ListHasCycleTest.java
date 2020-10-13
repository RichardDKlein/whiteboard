package com.whiteboard;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ListHasCycleTest {

    @Test
    void listHasCycle() {
        System.out.println();
        System.out.println("Test ListHasCycle:");
        System.out.println("==================");

        ListNode<Character> acyclicList = TestUtils.createList(
                Arrays.asList('a','b','c','d','e','f','g'));

        ListNode<Character> cyclicList = TestUtils.createList(
                Arrays.asList('a','b','c','d','e','f','g'));
        ListNode<Character> cNode = TestUtils.findNode(cyclicList, 'c');
        ListNode<Character> gNode = TestUtils.findNode(cyclicList, 'g');
        gNode.next = cNode;

        TestUtils.printList(acyclicList);
        boolean hasCycle = ListHasCycle.listHasCycle(acyclicList);
        assert(!hasCycle);
        System.out.println("Has cycle = " + hasCycle);

        TestUtils.printList(cyclicList, 22);
        hasCycle = ListHasCycle.listHasCycle(cyclicList);
        assert(hasCycle);
        System.out.println("Has cycle = " + hasCycle);
    }
}
