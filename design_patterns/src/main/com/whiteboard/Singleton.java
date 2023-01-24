package java.com.whiteboard;

/**
 * Singleton design pattern.
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // construction logic
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
