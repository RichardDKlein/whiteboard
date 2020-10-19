package com.whiteboard;

/**
 * Implements a queue using a circular buffer.
 *
 * We keep two private indices, head and tail. The head
 * points to the element at the head of the queue. The
 * tail points to the next free slot at the end of the
 * queue. The head and tail chase each other around the
 * circular buffer as elements are added and removed.
 *
 * The queue is considered empty when the head and the tail
 * point to the same element. The queue is considered full
 * when the next element after the tail is the head. Since
 * the tail always points to the next free slot, a full
 * queue contains exactly one free, and unusable, slot.
 * Thus the capacity of a buffer of length n is actually
 * (n - 1).
 */
public class CircularQueue {
    private int[] buf;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        buf = new int[capacity];
    }

    public boolean add(int element) {
        if (isFull()) {
            return false;
        }
        buf[tail] = element;
        tail = (tail + 1) % buf.length;
        return true;
    }

    public Integer poll() {
        Integer result;
        if (isEmpty()) {
            return null;
        }
        result = buf[head];
        head = (head + 1) % buf.length;
        return result;
    }

    private boolean isFull() {
        return (tail + 1) % buf.length == head;
    }

    private boolean isEmpty() {
        return head == tail;
    }
}
