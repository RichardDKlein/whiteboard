package com.whiteboard.lists;

/**
 * Reverse a singly-linked list in place, using an iterative
 * approach.
 */
public final class ReverseListIterative {
    private ReverseListIterative() {}

    /**
     * Reverse a singly-linked list in place, using an iterative
     * approach.
     *
     * @param head The head node of the list to be reversed.
     * @return The head node of the reversed list.
     */
    public static <E> ListNode<E> reverseListIterative(ListNode<E> head) {
        ListNode<E> rev = null;
        ListNode<E> curr = head;
        while (curr != null) {
            ListNode<E> next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
        }
        return rev;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ReverseListIterative:");
        System.out.println("==========================");

        ListNode<Character> list = null;
        System.out.println("Original list:");
        TestUtils.printList(list);
        ListNode<Character> rev = reverseListIterative(list);
        System.out.println("\nReversed list:");
        TestUtils.printList(rev);

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
        TestUtils.printList(list);
        rev = reverseListIterative(list);
        System.out.println("\nReversed list:");
        TestUtils.printList(rev);

        aNode.next = bNode;
        bNode.next = cNode;
        cNode.next = dNode;
        dNode.next = eNode;
        eNode.next = fNode;
        fNode.next = gNode;
        gNode.next = null;
        list = aNode;
        System.out.println("\nOriginal list:");
        TestUtils.printList(list);
        rev = reverseListIterative(list);
        System.out.println("\nReversed list:");
        TestUtils.printList(rev);
    }
}
