package lists;

public final class TestLists {
    private TestLists() {}

    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                    LISTS                    ");
        System.out.println("=============================================");

        DeleteNode.test();
        KthToLastInList.test();
        ListHasCycle.test();
        RemoveDupsFromList.test();
        ReverseListIterative.test();
        ReverseListRecursive.test();
    }
}
