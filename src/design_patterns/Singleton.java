package design_patterns;

/**
 * Singleton design pattern.
 */
public class Singleton {
    private static Singleton instance_;
    private Singleton() {
        // construction logic
    }
    public static Singleton instance() {
        if (instance_ == null) {
            instance_ = new Singleton();
        }
        return instance_;
    }

    static void test() {
        System.out.println();
        System.out.println("Test Singleton:");
        System.out.println("===============");

        Singleton instance1 = Singleton.instance();
        Singleton instance2 = Singleton.instance();

        System.out.println("1st time: Singleton.instance() = "
            + instance1);
        System.out.println("2nd time: Singleton.instance() = "
            + instance2);
    }
}
