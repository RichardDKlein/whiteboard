package lists;

public class TestLists {
    private TestLists() {}
    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                 LINKED LISTS                ");
        System.out.println("=============================================");

        KthToLastInList.test();
        RemoveDupsFromList.test();
        ReverseListIterative.test();
        ReverseListRecursive.test();
    }
}
