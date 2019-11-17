package stacks_and_queues;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 */
public class QueueUsingTwoStacks<E> {
    Stack<E> addStack;
    Stack<E> removeStack;

    public QueueUsingTwoStacks() {
        addStack = new Stack<>();
        removeStack = new Stack<>();
    }

    public void add(E element) {
        addStack.push(element);
    }

    public E remove() {
        if (removeStack.isEmpty()) {
            while (!addStack.isEmpty()) {
                removeStack.push(addStack.pop());
            }
        }
        return removeStack.pop();
    }

    public static void test() {
        System.out.println();
        System.out.println("Test QueueUsingTwoStacks():");
        System.out.println("===========================");

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
        System.out.println("Remove seven elements:");
        for (int i = 0; i < 7; ++i) {
            System.out.print(queue.remove() + " ");
        }
    }
}
