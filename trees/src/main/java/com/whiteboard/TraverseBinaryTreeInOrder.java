package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Perform an inorder traversal of a binary tree.
 */
public class TraverseBinaryTreeInOrder<E> {
    /**
     * Perform an inorder traversal of a binary tree.
     *
     * @param root The root of the binary tree to be traversed.
     * @return A list of the items in the binary tree, ordered
     * in accordance with an inorder traversal of the tree.
     */
    public List<E> traverseBinaryTreeInOrder(BinaryTreeNode<E> root) {
        List<E> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result = traverseBinaryTreeInOrder(root.left);
        result.add(root.data);
        List<E> right = traverseBinaryTreeInOrder(root.right);
        result.addAll(right);
        return result;
    }
}
