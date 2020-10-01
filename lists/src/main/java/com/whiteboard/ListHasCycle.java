package com.whiteboard;

/**
 * Determine whether a singly-linked list contains a cycle.
 */
public class ListHasCycle<E> {
    /**
     * Determine whether a singly-linked list contains a cycle.
     *
     * Our algorithm is the classic approach utilizing two
     * pointers to iterate thru the list: A slow pointer, which
     * iterates by one list element at a time; and a fast pointer,
     * which iterates by two list elements at a time. If the fast
     * pointer ever "laps" the slow pointer, then the list contains
     * a cycle.
     *
     * @param head The list of interest
     * @return A boolean indicating whether or not
     * the specified list contains a cycle.
     */
    public boolean listHasCycle(ListNode<E> head) {
        if (head == null) {
            return false;
        }
        ListNode<E> slow = head;
        ListNode<E> fast = head.next;
        while (fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return fast == slow;
    }
}
