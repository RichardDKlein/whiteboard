package com.whiteboard;

import org.junit.jupiter.api.Test;

class QueueUsingTwoStacksTest {
    @Test
    void test1() {
        System.out.println();
        System.out.println("Test QueueUsingTwoStacks:");
        System.out.println("=========================");

        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();
        System.out.println("Add five elements");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("Remove five elements:");
        for (int i = 0; i < 5; ++i) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
        System.out.println("Add five more elements");
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        System.out.println("Remove three elements:");
        for (int i = 0; i < 3; ++i) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
        System.out.println("Add five more elements");
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(15);
        System.out.println("Remove eight elements:");
        for (int i = 0; i < 8; ++i) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
