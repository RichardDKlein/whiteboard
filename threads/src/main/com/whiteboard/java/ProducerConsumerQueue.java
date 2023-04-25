package com.whiteboard.java;

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
    private Queue<E> queue = new LinkedList<>();
    private int capacity;

    public ProducerConsumerQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(E item) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(item);
        // notify consumer threads blocked on empty queue
        notifyAll();
    }

    public synchronized E consume() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        E item = queue.poll();
        // notify producer threads blocked on full queue
        notifyAll();
        return item;
    }

    private boolean isFull() {
        return queue.size() >= capacity;
    }
}
