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
public class CircularBuffer {
    int[] buffer_;
    int head_;
    int tail_;

    public CircularBuffer(int capacity) {
        buffer_ = new int[capacity];
        head_ = tail_ = 0;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("FULL!");
        } else {
            buffer_[tail_] = n;
            tail_ = (tail_ + 1) % buffer_.length;
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("EMPTY!");
            return -1;
        } else {
            int element = buffer_[head_];
            head_ = (head_ + 1) % buffer_.length;
            return element;
        }
    }

    private boolean isFull() {
        return (tail_ + 1) % buffer_.length == head_;
    }

    private boolean isEmpty() {
        return head_ == tail_;
    }
}
