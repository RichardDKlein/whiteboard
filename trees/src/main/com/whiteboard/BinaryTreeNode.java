package com.whiteboard;

public class BinaryTreeNode<E> {
    E data;
    BinaryTreeNode<E> left, right;

    BinaryTreeNode(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BinaryTreeNode<?> other)) {
            return false;
        }
        return this.data == other.data && this.left.equals(other.left) && this.right.equals(other.right);
    }
}
