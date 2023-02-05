package com.whiteboard;

import java.util.Stack;

/**
 * Implement a queue using two stacks.
 */
public class QueueUsingTwoStacks<E> {
    private Stack<E> addStack = new Stack<>();
    private Stack<E> removeStack = new Stack<>();

    public void add(E element) {
        addStack.push(element);
    }

    public E poll() {
        if (removeStack.isEmpty()) {
            while (!addStack.isEmpty()) {
                removeStack.push(addStack.pop());
            }
        }
        return !removeStack.isEmpty() ? removeStack.pop() : null;
    }
}
