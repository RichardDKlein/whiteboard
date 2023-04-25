package com.whiteboard.java;

/**
 * ReverseList a singly-linked list in place.
 */
public final class ReverseList {
    private ReverseList() {
    }

    /**
     * ReverseList a singly-linked list in place.
     *
     * @param head The head node of the list to be reversed.
     * @return The head node of the reversed list.
     */
    public static <E> ListNode<E> reverseList(ListNode<E> head) {
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
