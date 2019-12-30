package trees;

public final class TestTrees {
    private TestTrees() {}

    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                    TREES                    ");
        System.out.println("=============================================");

        CreateBinarySearchTreeFromSortedList.test();
        TraverseBinaryTreeInOrder.test();
    }
}
