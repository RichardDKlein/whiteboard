package com.whiteboard;

class SingletonTest {
    @org.junit.jupiter.api.Test
    void test() {
        System.out.println();
        System.out.println("Test Singleton:");
        System.out.println("===============");

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        assert(instance1.equals(instance2));

        System.out.println("1st time: instance() = "
                + instance1);
        System.out.println("2nd time: instance() = "
                + instance2);
    }
}
