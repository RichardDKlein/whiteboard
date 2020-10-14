package com.whiteboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a binary search tree from a sorted list.
 */
public final class CreateBinarySearchTreeFromSortedList {
    private CreateBinarySearchTreeFromSortedList() {
    }

    /**
     * Create a binary search tree from a sorted list.
     *
     * @param sortedList The sorted list.
     * @return The root of the created binary search tree.
     * Will be null if the given sorted list is empty.
     */
    public static <E> BinaryTreeNode<E>
    createBinarySearchTreeFromSortedList(List<E> sortedList) {
        if (sortedList.isEmpty()) {
            return null;
        }
        int first = 0;
        int last = sortedList.size() - 1;
        int mid = (first + last) / 2;

        List<E> leftSortedList = new ArrayList<>();
        for (int i = first; i < mid; ++i) {
            leftSortedList.add(sortedList.get(i));
        }
        List<E> rightSortedList = new ArrayList<>();
        for (int i = mid + 1; i <= last; ++i) {
            rightSortedList.add(sortedList.get(i));
        }
        BinaryTreeNode<E> root = new BinaryTreeNode<>();
        root.data = sortedList.get(mid);
        root.left = createBinarySearchTreeFromSortedList(leftSortedList);
        root.right = createBinarySearchTreeFromSortedList(rightSortedList);

        return root;
    }
}
