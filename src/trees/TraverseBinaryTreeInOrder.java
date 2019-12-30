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
     * @return A list of the items in the binary tree, whose order
     * corresponds to an inorder traversal of the tree.
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

        BinaryTreeNode<Integer> one = new BinaryTreeNode<>();
        one.data = 1;
        one.left = null;
        one.right = null;

        BinaryTreeNode<Integer> three = new BinaryTreeNode<>();
        three.data = 3;
        three.left = null;
        three.right = null;

        BinaryTreeNode<Integer> two = new BinaryTreeNode<>();
        two.data = 2;
        two.left = one;
        two.right = three;

        BinaryTreeNode<Integer> five = new BinaryTreeNode<>();
        five.data = 5;
        five.left = null;
        five.right = null;

        BinaryTreeNode<Integer> eight = new BinaryTreeNode<>();
        eight.data = 8;
        eight.left = null;
        eight.right = null;

        BinaryTreeNode<Integer> seven = new BinaryTreeNode<>();
        seven.data = 7;
        seven.left = null;
        seven.right = eight;

        BinaryTreeNode<Integer> six = new BinaryTreeNode<>();
        six.data = 6;
        six.left = five;
        six.right = seven;

        BinaryTreeNode<Integer> four = new BinaryTreeNode<>();
        four.data = 4;
        four.left = two;
        four.right = six;

        BinaryTreeNode<Integer> ten = new BinaryTreeNode<>();
        ten.data = 10;
        ten.left = null;
        ten.right = null;

        BinaryTreeNode<Integer> twelve = new BinaryTreeNode<>();
        twelve.data = 12;
        twelve.left = null;
        twelve.right = null;

        BinaryTreeNode<Integer> eleven = new BinaryTreeNode<>();
        eleven.data = 11;
        eleven.left = ten;
        eleven.right = twelve;

        BinaryTreeNode<Integer> fourteen = new BinaryTreeNode<>();
        fourteen.data = 14;
        fourteen.left = null;
        fourteen.right = null;

        BinaryTreeNode<Integer> seventeen = new BinaryTreeNode<>();
        seventeen.data = 17;
        seventeen.left = null;
        seventeen.right = null;

        BinaryTreeNode<Integer> sixteen = new BinaryTreeNode<>();
        sixteen.data = 16;
        sixteen.left = null;
        sixteen.right = seventeen;

        BinaryTreeNode<Integer> fifteen = new BinaryTreeNode<>();
        fifteen.data = 15;
        fifteen.left = fourteen;
        fifteen.right = sixteen;

        BinaryTreeNode<Integer> thirteen = new BinaryTreeNode<>();
        thirteen.data = 13;
        thirteen.left = eleven;
        thirteen.right = fifteen;

        BinaryTreeNode<Integer> nine = new BinaryTreeNode<>();
        nine.data = 9;
        nine.left = four;
        nine.right = thirteen;

        List<Integer> inorderTraversal = traverseBinaryTreeInOrder(nine);
        System.out.println("traverse BST inorder = " +
                Arrays.toString(inorderTraversal.toArray()));
    }
}
