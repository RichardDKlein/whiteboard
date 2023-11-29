package com.whiteboard.java;

import java.util.List;

/**
 * Test utilities for the lists package.
 */
public final class ListTestUtils {
    private ListTestUtils() {
    }

    static <E> ListNode<E> createList(List<E> data) {
        if (data.isEmpty()) {
            return null;
        }
        ListNode<E> result = new ListNode<>(data.get(0));
        ListNode<E> previousNode = result;
        for (int i = 1; i < data.size(); ++i) {
            ListNode<E> currentNode = new ListNode<E>(data.get(i));
            previousNode.next = currentNode;
            previousNode = currentNode;
        }
        return result;
    }

    static <E> boolean listsAreEqual(ListNode<E> list1, ListNode<E> list2) {
        ListNode<E> currNode1 = list1;
        ListNode<E> currNode2 = list2;
        while (currNode1 != null && currNode2 != null) {
            if (currNode1.data != currNode2.data) {
                return false;
            }
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }
        if (currNode1 != null || currNode2 != null) {
            return false;
        }
        return true;
    }

    static <E> ListNode<E> findNode(ListNode<E> root, E data) {
        ListNode<E> currNode = root;
        while (currNode != null) {
            if (currNode.data == data) {
                return currNode;
            }
            currNode = currNode.next;
        }
        return null;
    }

    static <E> String listToString(ListNode<E> head) {
        if (head == null) {
            return "<empty>";
        }
        StringBuilder builder = new StringBuilder();
        ListNode<E> curr = head;
        boolean atHead = true;
        while (curr != null) {
            if (!atHead) {
                builder.append("->");
            } else {
                atHead = false;
            }
            builder.append(curr.data);
            curr = curr.next;
        }
        return builder.toString();
    }

    static <E> void printList(ListNode<E> head) {
        System.out.println(listToString(head));
    }

    static <E> String listToString(ListNode<E> head, int max) {
        if (head == null) {
            return "<empty>";
        }
        StringBuilder builder = new StringBuilder();
        ListNode<E> curr = head;
        boolean atHead = true;
        int count = 0;
        while (curr != null) {
            if (!atHead) {
                builder.append("->");
            } else {
                atHead = false;
            }
            builder.append(curr.data);
            if (++count >= max) {
                builder.append("-> ...");
                break;
            }
            curr = curr.next;
        }
        return builder.toString();
    }

    static <E> void printList(ListNode<E> head, int max) {
        System.out.println(listToString(head, max));
    }
}
