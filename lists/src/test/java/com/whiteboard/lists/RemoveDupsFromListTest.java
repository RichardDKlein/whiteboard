package com.whiteboard.lists;

import org.junit.jupiter.api.Test;

class RemoveDupsFromListTest {

    @Test
    void removeDupsFromList() {
        System.out.println();
        System.out.println("Test RemoveDupsFromList:");
        System.out.println("========================");

        ListNode<Character> a1Node = new ListNode<>();
        ListNode<Character> b1Node = new ListNode<>();
        ListNode<Character> c1Node = new ListNode<>();
        ListNode<Character> a2Node = new ListNode<>();
        ListNode<Character> d1Node = new ListNode<>();
        ListNode<Character> e1Node = new ListNode<>();
        ListNode<Character> b2Node = new ListNode<>();
        ListNode<Character> f1Node = new ListNode<>();
        ListNode<Character> d2Node = new ListNode<>();
        ListNode<Character> g1Node = new ListNode<>();
        ListNode<Character> c2Node = new ListNode<>();
        ListNode<Character> e2Node = new ListNode<>();
        ListNode<Character> g2Node = new ListNode<>();

        a1Node.data = 'a'; a1Node.next = b1Node;
        b1Node.data = 'b'; b1Node.next = c1Node;
        c1Node.data = 'c'; c1Node.next = a2Node;
        a2Node.data = 'a'; a2Node.next = d1Node;
        d1Node.data = 'd'; d1Node.next = e1Node;
        e1Node.data = 'e'; e1Node.next = b2Node;
        b2Node.data = 'b'; b2Node.next = f1Node;
        f1Node.data = 'f'; f1Node.next = d2Node;
        d2Node.data = 'd'; d2Node.next = g1Node;
        g1Node.data = 'g'; g1Node.next = c2Node;
        c2Node.data = 'c'; c2Node.next = e2Node;
        e2Node.data = 'e'; e2Node.next = g2Node;
        g2Node.data = 'g'; g2Node.next = null;

        TestUtils.printList(a1Node);
        System.out.println("Removing duplicates:");
        new RemoveDupsFromList<Character>().removeDupsFromList(a1Node);
        TestUtils.printList(a1Node);
    }
}
