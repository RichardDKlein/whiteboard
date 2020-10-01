package com.whiteboard;

import org.junit.jupiter.api.Test;

class KthToLastInListTest {

    @Test
    void kthToLastInList() {
        System.out.println();
        System.out.println("Test KthToLastInList:");
        System.out.println("=====================");

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

        KthToLastInList<Character> instance = new KthToLastInList<>();

        for (int k = 1; k <= 8; ++k) {
            ListNode<Character> kthToLast = instance.kthToLastInList(aNode, k);
            System.out.println("kth to last element (k = " + k + ") is " +
                    ((kthToLast != null) ? kthToLast.data : "undefined"));
        }
    }
}
