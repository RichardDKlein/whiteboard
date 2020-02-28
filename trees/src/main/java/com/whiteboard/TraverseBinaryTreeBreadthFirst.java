package com.whiteboard;

import java.util.*;

/**
 * Perform a breadth-first traversal of a binary tree.
 */
public class TraverseBinaryTreeBreadthFirst<E> {
    /**
     * Perform a breadth-first traversal of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return A list of the items in the binary tree, ordered
     * in accordance with a breadth-first traversal of the tree.
     */
    public List<E> traverseBinaryTreeBreadthFirst(BinaryTreeNode<E> root) {
        List<E> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTreeNode<E>> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode<E> node = nodeQueue.poll();
            result.add(node.data);
            if (node.left != null) {
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
            }
        }
        return result;
    }
}
