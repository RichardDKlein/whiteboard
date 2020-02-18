package threads;

import com.whiteboard.lists.ShuffleList;

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
    private int capacity_;
    private Queue<E> queue_;

    public ProducerConsumerQueue(int capacity) {
        capacity_ = capacity;
        queue_ = new LinkedList<>();
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

    public static void test() {
        System.out.println();
        System.out.println("Test ProducerConsumerQueue:");
        System.out.println("===========================");

        ProducerConsumerQueue<String> queue = new ProducerConsumerQueue<>(5);

        class Producer extends Thread {
            int id_;
            Producer(int id) {
                id_ = id;
            }
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    String item = "Item P" + id_ + "." + i;
                    queue.produce(item);
                    System.out.println("Producer " + id_ + " produced " + item);
                    try {
                        sleep(ShuffleList.random(100, 500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("====> Producer " + id_ + " produced 10 items, exiting.");
            }
        }

        class Consumer extends Thread {
            int id_;
            Consumer(int id) {
                id_ = id;
            }
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    String item = queue.consume();
                    System.out.println("Consumer " + id_ + " consumed " + item);
                    try {
                        sleep(ShuffleList.random(100, 500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("====> Consumer " + id_ + " consumed 10 items, exiting.");
            }
        }

        Thread c1 = new Consumer(1); c1.start();
        Thread c2 = new Consumer(2); c2.start();
        Thread c3 = new Consumer(3); c3.start();

        Thread p1 = new Producer(1); p1.start();
        Thread p2 = new Producer(2); p2.start();
        Thread p3 = new Producer(3); p3.start();

        try {
            c1.join();
            c2.join();
            c3.join();

            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
