package com.whiteboard;

import com.whiteboard.ListNode;

/**
 * Test utilities for the lists package.
 */
public final class TestUtils<E> {
    void printList(ListNode<E> head) {
        if (head == null) {
            System.out.println("<empty>");
            return;
        }
        ListNode<E> curr = head;
        boolean atHead = true;
        while (curr != null) {
            if (!atHead) {
                System.out.print("->");
            } else {
                atHead = false;
            }
            System.out.print(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    void printList(ListNode<E> head, int max) {
        if (head == null) {
            System.out.println("<empty>");
            return;
        }
        ListNode<E> curr = head;
        boolean atHead = true;
        int count = 0;
        while (curr != null) {
            if (!atHead) {
                System.out.print("->");
            } else {
                atHead = false;
            }
            System.out.print(curr.data);
            if (++count >= max) {
                System.out.print("-> ...");
                break;
            }
            curr = curr.next;
        }
        System.out.println();
    }
}
