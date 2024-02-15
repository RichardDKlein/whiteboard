package com.whiteboard.java;

/**
 * Implement a queue using a circular buffer.
 *
 * We keep two private indices, head and tail. The head
 * points to the element at the head of the queue. The
 * tail points to the next free slot at the end of the
 * queue. The tail and head chase each other around the
 * circular buffer as elements are added and removed.
 *
 * The queue is considered empty when the head and the tail
 * point to the same element. The queue is considered full
 * when the next element after the tail is the head. Since
 * the tail always points to the next free slot, a full queue
 * contains exactly one free, and unusable, slot. Thus, if we
 * want a queue that can hold `capacity` elements, we need to
 * allocate a buffer of length (capacity + 1).
 */
public class CircularQueue {
    private Integer[] buf;
    private int head;
    private int tail;

    /**
     * General constructor.
     *
     * @param capacity The maximum number of elements that
     *                 the queue can hold.
     */
    public CircularQueue(int capacity) {
        buf = new Integer[capacity + 1];
    }

    /**
     * Append an element to the queue.
     *
     * @param element The element to be appended.
     * @return 'true' if the append operation was successful,
     * 'false' otherwise.
     */
    public boolean add(int element) {
        if (isFull()) {
            return false;
        }
        buf[tail] = element;
        tail = (tail + 1) % buf.length;
        return true;
    }

    /**
     * Remove an element from the front of the queue.
     *
     * @return the element that was removed from the
     * front of the queue, or `null` if the queue is
     * empty.
     */
    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int element = buf[head];
        buf[head] = null;
        head = (head + 1) % buf.length;
        return element;
    }

    /**
     * Determine whether the queue is full.
     *
     * @return 'true' if the queue is full, 'false'
     * otherwise.
     */
    private boolean isFull() {
        return ((tail + 1) % buf.length) == head;
    }

    /**
     * Determine whether the queue is empty.
     *
     * @return 'true' if the queue is empty, 'false'
     * otherwise.
     */
    private boolean isEmpty() {
        return head == tail;
    }
}
