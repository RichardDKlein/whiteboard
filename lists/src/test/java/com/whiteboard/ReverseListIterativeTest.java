package com.whiteboard;

import org.junit.jupiter.api.Test;

class ReverseListIterativeTest {

    @Test
    void reverseListIterative() {
        System.out.println();
        System.out.println("Test ReverseListIterative:");
        System.out.println("==========================");

        ListNode<Character> list = null;
        System.out.println("Original list:");
        TestUtils<Character> testUtils = new TestUtils<>();
        testUtils.printList(list);
        ReverseListIterative<Character> instance = new ReverseListIterative<>();
        ListNode<Character> rev = instance.reverseListIterative(list);
        System.out.println("\nReversed list:");
        testUtils.printList(rev);

        ListNode<Character> aNode = new ListNode<>();
        ListNode<Character> bNode = new ListNode<>();
        ListNode<Character> cNode = new ListNode<>();
        ListNode<Character> dNode = new ListNode<>();
        ListNode<Character> eNode = new ListNode<>();
        ListNode<Character> fNode = new ListNode<>();
        ListNode<Character> gNode = new ListNode<>();

        aNode.data = 'a';
        bNode.data = 'b';
        cNode.data = 'c';
        dNode.data = 'd';
        eNode.data = 'e';
        fNode.data = 'f';
        gNode.data = 'g';

        aNode.next = null;
        list = aNode;
        System.out.println("\nOriginal list:");
        testUtils.printList(list);
        rev = instance.reverseListIterative(list);
        System.out.println("\nReversed list:");
        testUtils.printList(rev);

        aNode.next = bNode;
        bNode.next = cNode;
        cNode.next = dNode;
        dNode.next = eNode;
        eNode.next = fNode;
        fNode.next = gNode;
        gNode.next = null;
        list = aNode;
        System.out.println("\nOriginal list:");
        testUtils.printList(list);
        rev = instance.reverseListIterative(list);
        System.out.println("\nReversed list:");
        testUtils.printList(rev);
    }
}
