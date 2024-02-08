package com.whiteboard.java;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CircularQueueTest {
    private static CircularQueue queue;

    @BeforeClass
    public static void beforeClass() {
        System.out.println();
        System.out.println("Test CircularQueue:");
        System.out.println("===================");
    }

    @Before
    public void beforeEachTest() {
        System.out.println(
                "Creating a CircularQueue that can hold 10 elements");
        queue = new CircularQueue(10);
    }

    @Test
    public void addAndRemove() {
        // add five elements
        System.out.println();
        assert(add(1));
        assert(add(2));
        assert(add(3));
        assert(add(4));
        assert(add(5));

        // remove three elements
        System.out.println();
        for (int i = 0; i < 3; ++i) {
            Integer element = remove();
            assert(element == i + 1);
        }

        // add five more elements
        System.out.println();
        assert(add(6));
        assert(add(7));
        assert(add(8));
        assert(add(9));
        assert(add(10));

        // remove two more elements
        System.out.println();
        for (int i = 0; i < 2; ++i) {
            Integer element = remove();
            assert(element == i + 4);
        }

        // add five more elements
        System.out.println();
        assert(add(11));
        assert(add(12));
        assert(add(13));
        assert(add(14));
        assert(add(15));

        // try to add one more element
        // (should fail -- queue full)
        System.out.println();
        assert(!add(16));

        // remove three more elements
        System.out.println();
        for (int i = 0; i < 3; ++i) {
            Integer element = remove();
            assert(element == i + 6);
        }

        // add three more elements
        System.out.println();
        assert(add(17));
        assert(add(18));
        assert(add(19));

        // try to add one more element
        // (should fail -- queue full)
        System.out.println();
        assert(!add(20));

        // remove six elements
        System.out.println();
        for (int i = 0; i < 7; i++) {
            Integer element = remove();
            assert(element == i + 9);
        }

        // remove three more elements
        System.out.println();
        for (int i = 0; i < 3; i++) {
            Integer element = remove();
            assert(element == i + 17);
        }

        // try to remove another element
        // (should fail - queue empty)
        System.out.println();
        Integer element = remove();
        assert(element == null);
    }

    private static boolean add(int element) {
        System.out.print("Adding element " + element);
        boolean success = queue.add(element);
        if (success) {
            System.out.println(" ... success");
        } else {
            System.out.println(" ... FAILED (queue full)");
        }
        return success;
    }

    private static Integer remove() {
        Integer result = queue.poll();
        if (result == null) {
            System.out.println("Removing element FAILED (queue empty)");
        } else {
            System.out.println("Removing element " + result);
        }
        return result;
    }
}
