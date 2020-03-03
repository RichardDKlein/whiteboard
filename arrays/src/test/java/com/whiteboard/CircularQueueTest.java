package com.whiteboard;

import org.junit.jupiter.api.Test;

class CircularQueueTest {
    @Test
    void circularBuffer() {
        System.out.println();
        System.out.println("Test CircularQueue:");
        System.out.println("===================");

        System.out.println("Create a CircularQueue of length 10");
        CircularQueue buf = new CircularQueue(10);
        System.out.println("Add five elements");
        buf.add(1);
        buf.add(2);
        buf.add(3);
        buf.add(4);
        buf.add(5);
        System.out.println("Remove five elements:");
        for (int i = 0; i < 5; ++i) {
            System.out.print(buf.poll() + " ");
        }
        System.out.println();
        System.out.println("Add five more elements");
        buf.add(6);
        buf.add(7);
        buf.add(8);
        buf.add(9);
        buf.add(10);
        System.out.println("Remove five elements:");
        for (int i = 0; i < 5; ++i) {
            System.out.print(buf.poll() + " ");
        }
        System.out.println();
        System.out.println("Add five more elements");
        buf.add(11);
        buf.add(12);
        buf.add(13);
        buf.add(14);
        buf.add(15);
        System.out.println("Remove five elements:");
        for (int i = 0; i < 5; ++i) {
            System.out.print(buf.poll() + " ");
        }
        System.out.println();
        System.out.println("Add ten elements");
        buf.add(1);
        buf.add(2);
        buf.add(3);
        buf.add(4);
        buf.add(5);
        buf.add(6);
        buf.add(7);
        buf.add(8);
        buf.add(9);
        buf.add(10);
        System.out.println("Remove ten elements:");
        for (int i = 0; i < 10; ++i) {
            System.out.print(buf.poll() + " ");
        }
        System.out.println();
    }
}
