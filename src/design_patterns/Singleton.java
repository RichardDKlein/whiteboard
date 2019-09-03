package design_patterns;

/**
 * Singleton design pattern.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton() {
        // add construction logic here
    }
    public static Singleton instance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    static void test() {
        System.out.println();
        System.out.println("Test Singleton:");
        System.out.println("===============");

        Singleton instance1 = instance();
        Singleton instance2 = instance();

        System.out.println("1st time: instance() = "
            + instance1);
        System.out.println("2nd time: instance() = "
            + instance2);
    }
}
