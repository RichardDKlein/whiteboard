package com.whiteboard;

import java.util.List;

/**
 * Determine whether a given binary tree is a binary search tree.
 */
public class IsBinarySearchTree<E extends Comparable<E>> {
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
    public boolean isBinarySearchTree(BinaryTreeNode<E> root) {
        List<E> inorderTraversal = new TraverseBinaryTreeInOrder<E>()
                .traverseBinaryTreeInOrder(root);

        for (int i = 0; i < inorderTraversal.size() - 1; ++i) {
            if (inorderTraversal.get(i).compareTo(
                    inorderTraversal.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
