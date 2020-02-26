package com.whiteboard;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 */
public class QueueUsingTwoStacks<E> {
    private Stack<E> addStack = new Stack<>();
    private Stack<E> removeStack = new Stack<>();

    public void add(E item) {
        addStack.push(item);
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
