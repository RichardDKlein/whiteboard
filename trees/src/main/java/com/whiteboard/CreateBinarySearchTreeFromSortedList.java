package com.whiteboard;

import java.util.ArrayList;
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
     * Will be null if the given sorted list is empty.
     */
    public BinaryTreeNode<E>
    createBinarySearchTreeFromSortedList(List<E> sortedList) {
        if (sortedList.isEmpty()) {
            return null;
        }
        int first = 0;
        int last = sortedList.size() - 1;
        int mid = (first + last) / 2;
        List<E> leftSublist = new ArrayList<>();
        for (int i = first; i < mid; ++i) {
            leftSublist.add(sortedList.get(i));
        }
        List<E> rightSublist = new ArrayList<>();
        for (int i = mid + 1; i <= last; ++i) {
            rightSublist.add(sortedList.get(i));
        }
        BinaryTreeNode<E> root = new BinaryTreeNode<>();
        root.data = sortedList.get(mid);
        root.left = createBinarySearchTreeFromSortedList(leftSublist);
        root.right = createBinarySearchTreeFromSortedList(rightSublist);

        return root;
    }
}
