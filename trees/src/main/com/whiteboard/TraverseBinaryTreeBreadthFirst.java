package com.whiteboard;

import java.util.*;

/**
 * Perform a breadth-first traversal of a binary tree.
 */
public final class TraverseBinaryTreeBreadthFirst {
    private TraverseBinaryTreeBreadthFirst() {
    }

    /**
     * Perform a breadth-first traversal of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return A list of the items in the binary tree, ordered
     * in accordance with a breadth-first traversal of the tree.
     */
    public static <E> List<E>
    traverseBinaryTreeBreadthFirst(BinaryTreeNode<E> root) {
        List<E> result = new ArrayList<>();
        Queue<BinaryTreeNode<E>> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode<E> node = nodeQueue.poll();
            if (node == null) {
                continue;
            }
            result.add(node.data);
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return result;
    }
}
