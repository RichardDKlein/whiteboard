package com.whiteboard;

/**
 * Reverse a singly-linked list in place, using an iterative
 * approach.
 */
public class ReverseListIterative<E> {
    /**
     * Reverse a singly-linked list in place, using an iterative
     * approach.
     *
     * @param head The head node of the list to be reversed.
     * @return The head node of the reversed list.
     */
    public ListNode<E> reverseListIterative(ListNode<E> head) {
        ListNode<E> reverse = null;
        ListNode<E> curr = head;
        while (curr != null) {
            ListNode<E> next = curr.next;
            curr.next = reverse;
            reverse = curr;
            curr = next;
        }
        return reverse;
    }
}
