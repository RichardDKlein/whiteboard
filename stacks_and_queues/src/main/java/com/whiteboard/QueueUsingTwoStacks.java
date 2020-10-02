package com.whiteboard;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 */
public class QueueUsingTwoStacks<E> {
    private final Stack<E> addStack = new Stack<>();
    private final Stack<E> removeStack = new Stack<>();

    public void add(E element) {
        addStack.push(element);
    }

    public E remove() {
        if (removeStack.isEmpty()) {
            while (!addStack.isEmpty()) {
                removeStack.push(addStack.pop());
            }
        }
        if (removeStack.isEmpty()) {
            return null;
        }
        return removeStack.pop();
    }
}
