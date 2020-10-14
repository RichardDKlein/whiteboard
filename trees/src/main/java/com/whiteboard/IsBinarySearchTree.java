package com.whiteboard;

import java.util.List;

/**
 * Determine whether a given binary tree is a binary search tree.
 */
public final class IsBinarySearchTree {
    private IsBinarySearchTree() {
    }

    /**
     * Determine whether a given binary tree is a binary search tree.
     *
     * The algorithm is to do an inorder traversal of the tree, and
     * then check whether the returned list is in ascending order.
     *
     * @param root The root of the binary tree to be checked.
     * @return 'true' if the given tree is a binary search tree,
     * 'false' otherwise.
     */
    public static
    boolean isBinarySearchTree(BinaryTreeNode<Integer> root) {
        List<Integer> inorderTraversal =
                TraverseBinaryTreeInOrder.traverseBinaryTreeInOrder(root);
        for (int i = 0; i < inorderTraversal.size() - 1; ++i) {
            if (inorderTraversal.get(i) > inorderTraversal.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
