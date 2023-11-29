package com.whiteboard.java;

/**
 * Extract a binary number from a singly-linked list, returning its
 * decimal equivalent.
 */
public final class BinaryNumberInList {
    private BinaryNumberInList() {
    }

    /**
     * Extract a binary number from a singly-linked list, returning its
     * decimal equivalent.
     *
     */
    public static int binaryNumberInList(ListNode<Integer> head) {
        int result = 0;
        if (head == null) {
            return result;
        }
        ListNode<Integer> curr = head;
        while (curr != null) {
            result = result * 2 + curr.data;
            curr = curr.next;
        }
        return result;
    }
}
