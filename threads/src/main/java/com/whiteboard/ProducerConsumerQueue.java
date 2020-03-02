package com.whiteboard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A queue that blocks producer threads when full,
 * and consumer threads when empty.
 *
 * NOTE: Implementation is not allowed to use Java
 * library classes that implement the BlockingQueue<E>
 * interface.
 */
public class ProducerConsumerQueue<E> {
    private Queue<E> queue_ = new LinkedList<>();
    int capacity_;

    ProducerConsumerQueue(int capacity) {
        capacity_ = capacity;
    }

    public synchronized void produce(E item) {
        while (queue_.size() >= capacity_) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue_.add(item);
        // Notify consumers that the queue is non-empty.
        notifyAll();
    }

    public synchronized E consume() {
        while (queue_.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        E item = queue_.poll();
        // Notify producers that the queue is non-full.
        notifyAll();
        return item;
    }
}
