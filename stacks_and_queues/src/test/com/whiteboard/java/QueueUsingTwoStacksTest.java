package com.whiteboard.java;

import org.junit.Test;

public class QueueUsingTwoStacksTest {
    @Test
    public void queueUsingTwoStacksTest() {
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
            Integer removedElement = queue.poll();
            assert(removedElement == 1 + i);
            System.out.print(removedElement + " ");
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
            Integer removedElement = queue.poll();
            assert(removedElement == 6 + i);
            System.out.print(removedElement + " ");
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
            Integer removedElement = queue.poll();
            if (i == 7) {
                assert(removedElement == null);
            } else {
                assert (removedElement == 9 + i);
            }
            System.out.print(removedElement + " ");
        }
        System.out.println();
    }
}
