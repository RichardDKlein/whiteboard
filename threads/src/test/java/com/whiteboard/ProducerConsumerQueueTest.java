package com.whiteboard;

import org.junit.jupiter.api.Test;

class ProducerConsumerQueueTest {
    ProducerConsumerQueue<String> queue_ =
            new ProducerConsumerQueue<>(5);

    @Test
    void test1() {
        System.out.println();
        System.out.println("Test ProducerConsumerQueue:");
        System.out.println("===========================");

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

    // ===================================================================
    // INNER CLASSES
    // ===================================================================

    class Producer extends Thread {
        int id_;

        Producer(int id) {
            id_ = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                String item = "Item P" + id_ + "." + i;
                queue_.produce(item);
                System.out.println("Producer " + id_ + " produced " + item);
                try {
                    sleep(Shuffle.randomInInterval(100, 500));
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
                String item = queue_.consume();
                System.out.println("Consumer " + id_ + " consumed " + item);
                try {
                    sleep(Shuffle.randomInInterval(100, 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("====> Consumer " + id_ + " consumed 10 items, exiting.");
        }
    }
}
