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
    private int[] buffer_;
    private int head_;
    private int tail_;

    CircularQueue(int capacity) {
        buffer_ = new int[capacity];
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("FULL!");
            return;
        }
        buffer_[tail_] = n;
        tail_ = (tail_ + 1) % buffer_.length;
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("EMPTY!");
            return -1;
        }
        int result = buffer_[head_];
        head_ = (head_ + 1) % buffer_.length;
        return result;
    }

    private boolean isFull() {
        return (tail_ + 1) % buffer_.length == head_;
    }

    private boolean isEmpty() {
        return head_ == tail_;
    }
}
