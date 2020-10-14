package com.whiteboard;

import org.junit.jupiter.api.Test;

class IsBinarySearchTreeTest {
    @Test
    void isBinarySearchTreeTest() {
        System.out.println();
        System.out.println("Test IsBinarySearchTree:");
        System.out.println("========================");

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, null, null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, null, null);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, null);

        System.out.println("        4      ");
        System.out.println("     2     6   ");
        System.out.println("    1 3   5 7  ");
        System.out.println();

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        boolean isBinarySearchTree = IsBinarySearchTree.isBinarySearchTree(node4);
        assert(isBinarySearchTree);
        System.out.println("Is Binary Search Tree = " + isBinarySearchTree);
        System.out.println();

        System.out.println("        4      ");
        System.out.println("     2     6   ");
        System.out.println("    1 5   3 7  ");
        System.out.println();

        node2.right = node5;
        node6.left = node3;

        isBinarySearchTree = IsBinarySearchTree.isBinarySearchTree(node4);
        assert(!isBinarySearchTree);
        System.out.println("Is Binary Search Tree = " + isBinarySearchTree);
        System.out.println();
    }
}
