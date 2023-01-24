package com.whiteboard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateBinarySearchTreeFromSortedListTest {
    @Test
    public void createBinarySearchTreeFromSortedListTest() {
        System.out.println();
        System.out.println("Test CreateBinarySearchTreeFromSortedList:");
        System.out.println("==========================================");

        System.out.println("               9                  ");
        System.out.println("        4            13           ");
        System.out.println("     2     6     11      15       ");
        System.out.println("    1 3   5 7  10  12  14  16     ");
        System.out.println("             8              17    ");
        System.out.println();

        int[] sortedArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        List<Integer> sortedList = new ArrayList<>();
        for (int integer : sortedArray) {
            sortedList.add(integer);
        }
        System.out.println("sorted list = " +
                Arrays.toString(sortedList.toArray()));
        BinaryTreeNode<Integer> root = CreateBinarySearchTreeFromSortedList
                .createBinarySearchTreeFromSortedList(sortedList);
        List<Integer> inorderTraversal = IsBinarySearchTree.traverseInorder(root);
        assert(inorderTraversal.equals(sortedList));
        System.out.println("inorder traversal of binary search tree = " +
                Arrays.toString(inorderTraversal.toArray()));
    }
}
