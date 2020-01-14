package design_patterns;

/**
 * Singleton design pattern.
 */
public class Singleton {
    private static Singleton instance_;

    private Singleton() {
        // construction logic
    }

    public static Singleton getInstance() {
        if (instance_ == null) {
            instance_ = new Singleton();
        }
        return instance_;
    }

    static void test() {
        System.out.println();
        System.out.println("Test Singleton:");
        System.out.println("===============");

        Singleton instance1 = getInstance();
        Singleton instance2 = getInstance();

        System.out.println("1st time: instance() = "
            + instance1);
        System.out.println("2nd time: instance() = "
            + instance2);
    }
}
