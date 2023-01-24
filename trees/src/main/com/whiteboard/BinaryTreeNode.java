package com.whiteboard;

public class BinaryTreeNode<E> {
    E data;
    BinaryTreeNode<E> left, right;

    BinaryTreeNode(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    BinaryTreeNode(E data) {
        this(data, null, null);
    }
}
