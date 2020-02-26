package com.whiteboard;

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
}
