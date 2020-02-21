package com.whiteboard;

/**
 * Reverse a singly-linked list in place, using a recursive
 * approach.
 */
public class ReverseListRecursive<E> {
    /**
     * Reverse a singly-linked list in place, using a recursive
     * approach.
     *
     * @param head The head node of the list to be reversed.
     * @return The head node of the reversed list.
     */
    public ListNode<E> reverseListRecursive(ListNode<E> head) {
        if (head == null) {
            return null;
        }
        ListNode<E> nodeAfterHead = head.next;
        ListNode<E> rev = reverseListRecursive(nodeAfterHead);
        if (rev == null) {
            return head;
        }
        ListNode<E> curr = rev;
        while (curr.next != null) {
            curr = curr.next;
        }
        ListNode<E> tail = curr;
        tail.next = head;
        head.next = null;
        return rev;
    }
}
