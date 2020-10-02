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
    Queue<E> queue = new LinkedList<>();
    int capacity;

    ProducerConsumerQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(E element) {
        while (queue.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(element);
        // notify consumers waiting for queue to be non-empty
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
        E element = queue.poll();
        // notify producers waiting for queue to be non-full
        notifyAll();
        return element;
    }
}
