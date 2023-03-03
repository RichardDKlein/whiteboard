package com.whiteboard;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 */
public class QueueUsingTwoStacks<E> {
    Stack<E> addStack = new Stack<>();
    Stack<E> pollStack = new Stack<>();

    public void add(E item) {
        addStack.push(item);
    }

    public E poll() {
        if (pollStack.isEmpty()) {
            while (!addStack.isEmpty()) {
                pollStack.push(addStack.pop());
            }
        }
        return pollStack.isEmpty() ? null : pollStack.pop();
    }
}
