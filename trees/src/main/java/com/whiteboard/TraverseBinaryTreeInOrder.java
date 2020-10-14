package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Perform an inorder traversal of a binary tree.
 */
public final class TraverseBinaryTreeInOrder {
    private TraverseBinaryTreeInOrder() {
    }

    /**
     * Perform an inorder traversal of a binary tree.
     *
     * @param root The root of the binary tree to be traversed.
     * @return A list of the items in the binary tree, ordered
     * in accordance with an inorder traversal of the tree.
     */
    public static <E> List<E> traverseBinaryTreeInOrder(BinaryTreeNode<E> root) {
        List<E> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(traverseBinaryTreeInOrder(root.left));
        result.add(root.data);
        result.addAll(traverseBinaryTreeInOrder(root.right));

        return result;
    }
}
