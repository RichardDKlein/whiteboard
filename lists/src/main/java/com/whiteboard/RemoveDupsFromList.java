package com.whiteboard;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicates from a singly-linked list.
 */
public class RemoveDupsFromList<E> {
    /**
     * Remove duplicates from a singly-linked list.
     * @param head The list of interest.
     */
    public void removeDupsFromList(ListNode<E> head) {
        ListNode<E> prev = null;
        ListNode<E> curr = head;
        Set<E> seen = new HashSet<>();
        while (curr != null) {
            if (seen.contains(curr.data)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                seen.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
    }
}
