package com.whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TraverseBinaryTreeBreadthFirstTest {
    @Test
    void traverseBinaryTreeBreadthFirst() {
        System.out.println();
        System.out.println("Test TraverseBinaryTreeBreadthFirst:");
        System.out.println("====================================");

        System.out.println("               9                  ");
        System.out.println("        4            13           ");
        System.out.println("     2     6     11      15       ");
        System.out.println("    1 3   5 7  10  12  14  16     ");
        System.out.println("             8              17    ");
        System.out.println();

        List<Integer> expectedList = new ArrayList<>(Arrays.asList(
                9,4,13,2,6,11,15,1,3,5,7,10,12,14,16,8,17
        ));

        List<Integer> sortedList = new ArrayList<>(Arrays.asList(
                1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17
        ));

        BinaryTreeNode<Integer> root =
                new CreateBinarySearchTreeFromSortedList<Integer>()
                        .createBinarySearchTreeFromSortedList(sortedList);
        List<Integer> breadthFirstTraversal =
                new TraverseBinaryTreeBreadthFirst<Integer>()
                        .traverseBinaryTreeBreadthFirst(root);
        assert(breadthFirstTraversal.equals(expectedList));
        System.out.println("breadth-first traversal of binary tree = " +
                Arrays.toString(breadthFirstTraversal.toArray()));
    }
}
