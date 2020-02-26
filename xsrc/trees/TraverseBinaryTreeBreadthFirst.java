package trees;

import java.util.*;

/**
 * Perform a breadth-first traversal of a binary tree.
 */
public class TraverseBinaryTreeBreadthFirst {
    private TraverseBinaryTreeBreadthFirst() {}

    /**
     * Perform a breadth-first traversal of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return A list of the items in the binary tree, ordered
     * in accordance with a breadth-first traversal of the tree.
     */
    public static <E> List<E> traverseBinaryTreeBreadthFirst(BinaryTreeNode<E> root) {
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

    public static void test() {
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
        List<Integer> breadthFirstTraversal = traverseBinaryTreeBreadthFirst(root);
        System.out.println("breadth-first traversal of binary tree = " +
                Arrays.toString(breadthFirstTraversal.toArray()));
    }
}
