package com.whiteboard;

import org.junit.jupiter.api.Test;

public class DeleteNodeTest {
    private ListNode<Character> aNode = new ListNode<>();
    private ListNode<Character> bNode = new ListNode<>();
    private ListNode<Character> cNode = new ListNode<>();
    private ListNode<Character> dNode = new ListNode<>();
    private ListNode<Character> eNode = new ListNode<>();
    private ListNode<Character> fNode = new ListNode<>();
    private ListNode<Character> gNode = new ListNode<>();

    @Test
    void deleteNode() {
        System.out.println();
        System.out.println("Test DeleteNode:");
        System.out.println("================");

        DeleteNode<Character> instance = new DeleteNode<>();
        boolean result;

        System.out.println("\nOriginal list:");
        ListNode<Character> list = createTestList();
        TestUtils<Character> testUtils = new TestUtils<>();
        testUtils.printList(list);

        System.out.println("\nDeleting Node 'a':");
        result = instance.deleteNode(aNode);
        testUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'b':");
        list = createTestList();
        result = instance.deleteNode(bNode);
        testUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'c':");
        list = createTestList();
        result = instance.deleteNode(cNode);
        testUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'd':");
        list = createTestList();
        result = instance.deleteNode(dNode);
        testUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'e':");
        list = createTestList();
        result = instance.deleteNode(eNode);
        testUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'f':");
        list = createTestList();
        result = instance.deleteNode(fNode);
        testUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'g':");
        list = createTestList();
        result = instance.deleteNode(gNode);
        testUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");
    }

    private ListNode<Character> createTestList() {
        aNode.data = 'a'; aNode.next = bNode;
        bNode.data = 'b'; bNode.next = cNode;
        cNode.data = 'c'; cNode.next = dNode;
        dNode.data = 'd'; dNode.next = eNode;
        eNode.data = 'e'; eNode.next = fNode;
        fNode.data = 'f'; fNode.next = gNode;
        gNode.data = 'g'; gNode.next = null;

        return aNode;
    }
}
