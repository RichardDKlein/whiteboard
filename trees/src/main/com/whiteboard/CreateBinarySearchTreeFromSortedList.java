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
        // base case
        if (sortedList.isEmpty()) {
            return null;
        }
        // recursive step
        int mid = (sortedList.size() - 1) / 2;
        E data = sortedList.get(mid);
        List<E> leftList = new ArrayList<>();
        for (int i = 0; i < mid; ++i) {
            leftList.add(sortedList.get(i));
        }
        BinaryTreeNode<E> left = createBinarySearchTreeFromSortedList(leftList);
        List<E> rightList = new ArrayList<>();
        for (int i = mid + 1; i < sortedList.size(); ++i) {
            rightList.add(sortedList.get(i));
        }
        BinaryTreeNode<E> right = createBinarySearchTreeFromSortedList(rightList);
        return new BinaryTreeNode<>(data, left, right);
    }
}
