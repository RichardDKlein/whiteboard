package com.whiteboard.java;

import org.junit.Test;

public class CircularQueueTest {
    private static CircularQueue queue;

    @Test
    public void circularQueueTest() {
        System.out.println();
        System.out.println("Test CircularQueue:");
        System.out.println("===================");

        boolean success;
        Integer element;

        System.out.println("Creating a CircularQueue of length 10");
        queue = new CircularQueue(10);

        System.out.println();

        success = add(1); assert(success);
        success = add(2); assert(success);
        success = add(3); assert(success);
        success = add(4); assert(success);
        success = add(5); assert(success);

        System.out.println();

        for (int i = 0; i < 3; ++i) {
            element = remove();
            assert(element == i + 1);
        }

        System.out.println();

        success = add(6); assert(success);
        success = add(7); assert(success);
        success = add(8); assert(success);
        success = add(9); assert(success);
        success = add(10); assert(success);

        System.out.println();

        for (int i = 0; i < 2; ++i) {
            element = remove();
            assert(element == i + 4);
        }

        System.out.println();

        success = add(11); assert(success);
        success = add(12); assert(success);
        success = add(13); assert(success);
        success = add(14); assert(success);
        success = add(15); assert(!success);

        System.out.println();

        for (int i = 0; i < 3; ++i) {
            element = remove();
            assert(element == i + 6);
        }

        System.out.println();

        success = add(16); assert(success);
        success = add(17); assert(success);
        success = add(18); assert(success);
        success = add(19); assert(!success);

        System.out.println();

        for (int i = 0; i < 10; ++i) {
            element = remove();
            if (i < 6) {
                assert(element == i + 9);
            } else if (i < 9) {
                assert (element == i + 10);
            } else {
                assert(element == null);
            }
        }
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
