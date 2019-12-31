package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a binary search tree from a sorted list.
 */
public final class CreateBinarySearchTreeFromSortedList {
    private CreateBinarySearchTreeFromSortedList() {}

    /**
     * Create a binary search tree from a sorted list.
     *
     * @param sortedList The sorted list.
     * @return The root of the created binary search tree.
     */
    public static <E> BinaryTreeNode<E>
    createBinarySearchTreeFromSortedList(List<E> sortedList) {
        if (sortedList.isEmpty()) {
            return null;
        }
        int first = 0;
        int last = sortedList.size() - 1;
        int mid = (first + last) / 2;
        List<E> left = new ArrayList<>();
        for (int i = 0; i < mid; ++i) {
            left.add(sortedList.get(i));
        }
        List<E> right = new ArrayList<>();
        for (int i = mid + 1; i <= last; ++i) {
            right.add(sortedList.get(i));
        }
        BinaryTreeNode<E> root = new BinaryTreeNode<>();
        root.data = sortedList.get(mid);
        root.left = createBinarySearchTreeFromSortedList(left);
        root.right = createBinarySearchTreeFromSortedList(right);

        return root;
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
        BinaryTreeNode<Integer> root =
                createBinarySearchTreeFromSortedList(sortedList);
        List<Integer> inorderTraversal =
                TraverseBinaryTreeInOrder.traverseBinaryTreeInOrder(root);
        System.out.println("inorder traversal of binary search tree = " +
                Arrays.toString(inorderTraversal.toArray()));
    }
}
