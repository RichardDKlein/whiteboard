package sets;

public class TestSets {
    private TestSets() {}
    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                    SETS                     ");
        System.out.println("=============================================");

        PowerSetIterative.test();
        PowerSetRecursive.test();
    }
}
