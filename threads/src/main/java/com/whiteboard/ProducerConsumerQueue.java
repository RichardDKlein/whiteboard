package java.com.whiteboard;

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
    int capacity;

    ProducerConsumerQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(E element) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(element);
        // notify consumer threads blocked on queue empty
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
        // notify producer threads blocked on queue full
        notifyAll();
        return element;
    }

    private boolean isFull() {
        return queue.size() >= this.capacity;
    }
}
