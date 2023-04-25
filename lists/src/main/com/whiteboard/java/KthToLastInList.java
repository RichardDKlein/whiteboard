package com.whiteboard.java;

/**
 * Find the kth to last element in a singly-linked list.
 */
public final class KthToLastInList {
    private KthToLastInList() {
    }

    /**
     * Find the kth to last element in a singly-linked list.
     *
     * @param head The list of interest.
     * @param k A positive integer.
     * @return The kth to last element in the list,
     * or null if the list does not contain k elements.
     */
    public static <E> ListNode<E> kthToLastInList(ListNode<E> head, int k) {
        ListNode<E> lead = head;
        for (int i = 0; i < k; ++i) {
            if (lead == null) {
                return null;
            }
            lead = lead.next;
        }
        ListNode<E> lag = head;
        while (lead != null) {
            lead = lead.next;
            lag = lag.next;
        }
        return lag;
    }
}
