package lists_homegrown;

public class TestListsHomegrown {
    private TestListsHomegrown() {}
    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("              LISTS - Homegrown              ");
        System.out.println("=============================================");

        DeleteNode.test();
        ListHasCycle.test();
    }
}
