package lists_standardlib;

public class TestListsStandardLib {
    private TestListsStandardLib() {}
    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("          LISTS - Standard Library           ");
        System.out.println("=============================================");

        KthToLastInList.test();
        RemoveDupsFromList.test();
    }
}
