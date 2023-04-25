package com.whiteboard.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicates from a singly-linked list.
 */
public final class RemoveDupsFromList {
    private RemoveDupsFromList() {
    }

    /**
     * Remove duplicates from a singly-linked list.
     * @param head The list of interest.
     */
    public static <E> void removeDupsFromList(ListNode<E> head) {
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
