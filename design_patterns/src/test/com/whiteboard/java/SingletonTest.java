package com.whiteboard.java;

import org.junit.Test;

public class SingletonTest {
    @Test
    public void testSingleton() {
        System.out.println();
        System.out.println("Test Singleton:");
        System.out.println("===============");

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        assert(instance1.equals(instance2));

        System.out.println("1st time: instance() = " + instance1);
        System.out.println("2nd time: instance() = " + instance2);
    }
}
