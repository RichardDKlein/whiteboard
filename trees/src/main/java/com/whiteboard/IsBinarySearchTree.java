package com.whiteboard;

import java.util.List;

public class IsBinarySearchTree<E extends Comparable<E>> {
    public boolean isBinarySearchTree(BinaryTreeNode<E> root) {
        List<E> list = new TraverseBinaryTreeInOrder<E>()
                .traverseBinaryTreeInOrder(root);
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i).compareTo(list.get(i - 1)) <= 0) {
                return false;
            }
        }
        return true;
    }
}
