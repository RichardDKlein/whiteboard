package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Perform an inorder traversal of a binary tree.
 */
public final class TraverseBinaryTreeInOrder {
    private TraverseBinaryTreeInOrder() {}

    /**
     * Perform an inorder traversal of a binary tree.
     *
     * @param root The root of the binary tree to be traversed.
     * @return A list of the items in the binary tree, ordered
     * in accordance with an inorder traversal of the tree.
     */
    public static <E> List<E> traverseBinaryTreeInOrder(BinaryTreeNode<E> root) {
        List<E> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result = traverseBinaryTreeInOrder(root.left);
        result.add(root.data);
        List<E> right = traverseBinaryTreeInOrder(root.right);
        result.addAll(right);
        return result;
    }

    public static void test() {
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

        List<Integer> inorderTraversal = traverseBinaryTreeInOrder(nine);
        System.out.println("inorder traversal of binary tree = " +
                Arrays.toString(inorderTraversal.toArray()));
    }
}
