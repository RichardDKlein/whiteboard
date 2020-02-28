package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a binary search tree from a sorted list.
 */
public class CreateBinarySearchTreeFromSortedList<E> {
    /**
     * Create a binary search tree from a sorted list.
     *
     * @param sortedList The sorted list.
     * @return The root of the created binary search tree.
     */
    public BinaryTreeNode<E>
    createBinarySearchTreeFromSortedList(List<E> sortedList) {
        if (sortedList.isEmpty()) {
            return null;
        }
        int first = 0;
        int last = sortedList.size() - 1;
        int mid = (first + last) / 2;
        List<E> left = new ArrayList<>();
        for (int i = 0; i < mid; ++i) {
            left.add(sortedList.get(i));
        }
        List<E> right = new ArrayList<>();
        for (int i = mid + 1; i <= last; ++i) {
            right.add(sortedList.get(i));
        }
        BinaryTreeNode<E> root = new BinaryTreeNode<>();
        root.data = sortedList.get(mid);
        root.left = createBinarySearchTreeFromSortedList(left);
        root.right = createBinarySearchTreeFromSortedList(right);

        return root;
    }
}
