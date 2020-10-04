package com.whiteboard;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TraverseBinaryTreeInOrderTest {
    @Test
    void traverseBinaryTreeInOrder() {
        System.out.println();
        System.out.println("Test TraverseBinaryTreeInOrder:");
        System.out.println("===============================");

        System.out.println("               9                  ");
        System.out.println("        4            13           ");
        System.out.println("     2     6     11      15       ");
        System.out.println("    1 3   5 7  10  12  14  16     ");
        System.out.println("             8              17    ");
        System.out.println();

        BinaryTreeNode<Integer> one = new BinaryTreeNode<>(1, null, null);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<>(2, one, three);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<>(5, null, null);
        BinaryTreeNode<Integer> eight = new BinaryTreeNode<>(8, null, null);
        BinaryTreeNode<Integer> seven = new BinaryTreeNode<>(7, null, eight);
        BinaryTreeNode<Integer> six = new BinaryTreeNode<>(6, five, seven);
        BinaryTreeNode<Integer> four = new BinaryTreeNode<>(4, two, six);
        BinaryTreeNode<Integer> ten = new BinaryTreeNode<>(10, null, null);
        BinaryTreeNode<Integer> twelve = new BinaryTreeNode<>(12, null, null);
        BinaryTreeNode<Integer> eleven = new BinaryTreeNode<>(11, ten, twelve);
        BinaryTreeNode<Integer> fourteen = new BinaryTreeNode<>(14, null, null);
        BinaryTreeNode<Integer> seventeen = new BinaryTreeNode<>(17, null, null);
        BinaryTreeNode<Integer> sixteen = new BinaryTreeNode<>(16, null, seventeen);
        BinaryTreeNode<Integer> fifteen = new BinaryTreeNode<>(15, fourteen, sixteen);
        BinaryTreeNode<Integer> thirteen = new BinaryTreeNode<>(13, eleven, fifteen);
        BinaryTreeNode<Integer> nine = new BinaryTreeNode<>(9, four, thirteen);

        List<Integer> inorderTraversal = new TraverseBinaryTreeInOrder<Integer>()
                        .traverseBinaryTreeInOrder(nine);
        for (int i = 0; i < inorderTraversal.size(); ++i) {
            assert(inorderTraversal.get(i) == i + 1);
        }
        System.out.println("inorder traversal of binary tree = " +
                Arrays.toString(inorderTraversal.toArray()));
    }
}
