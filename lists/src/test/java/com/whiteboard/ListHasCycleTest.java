package com.whiteboard;

import org.junit.jupiter.api.Test;

class ListHasCycleTest {

    @Test
    void listHasCycle() {
        System.out.println();
        System.out.println("Test ListHasCycle:");
        System.out.println("==================");

        ListNode<Character> aNode = new ListNode<>();
        ListNode<Character> bNode = new ListNode<>();
        ListNode<Character> cNode = new ListNode<>();
        ListNode<Character> dNode = new ListNode<>();
        ListNode<Character> eNode = new ListNode<>();
        ListNode<Character> fNode = new ListNode<>();
        ListNode<Character> gNode = new ListNode<>();

        aNode.data = 'a'; aNode.next = bNode;
        bNode.data = 'b'; bNode.next = cNode;
        cNode.data = 'c'; cNode.next = dNode;
        dNode.data = 'd'; dNode.next = eNode;
        eNode.data = 'e'; eNode.next = fNode;
        fNode.data = 'f'; fNode.next = gNode;
        gNode.data = 'g'; gNode.next = null;

        TestUtils<Character> testUtils = new TestUtils<>();
        testUtils.printList(aNode);

        ListHasCycle<Character> instance = new ListHasCycle<>();

        System.out.println("Has cycle = " + instance.listHasCycle(aNode));

        gNode.next = cNode;
        testUtils.printList(aNode, 22);
        System.out.println("Has cycle = " + instance.listHasCycle(aNode));
    }
}