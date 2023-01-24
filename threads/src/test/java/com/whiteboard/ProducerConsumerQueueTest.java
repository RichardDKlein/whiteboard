package java.com.whiteboard;

import org.junit.Test;

import java.util.Collections;
import java.util.Vector;

public class ProducerConsumerQueueTest {
    ProducerConsumerQueue<String> queue = new ProducerConsumerQueue<>(5);
    Vector<String> consumedItems = new Vector<>(); // Need Vector<> for thread safety

    class Producer extends Thread {
        int id;

        Producer(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; ++i) {
                String item = "Item P" + id + "." + i;
                queue.produce(item);
                System.out.println("Producer " + id + " produced " + item);
                try {
                    sleep(ShuffleList.randomIntegerInInterval(100, 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("====> Producer " + id + " produced 10 items, exiting.");
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
                consumedItems.add(item);
                System.out.println("Consumer " + id_ + " consumed " + item);
                try {
                    sleep(ShuffleList.randomIntegerInInterval(100, 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("====> Consumer " + id_ + " consumed 10 items, exiting.");
        }
    }

    @Test
    public void producerConsumerTest1() {
        System.out.println();
        System.out.println("Test ProducerConsumerQueue:");
        System.out.println("===========================");

        Vector<String> expectedItems = new Vector<>();
        for (int producerId = 1; producerId <= 3; ++producerId) {
            for (int itemId = 0; itemId < 10; ++itemId) {
                String item = "Item P" + producerId + "." + itemId;
                expectedItems.add(item);
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
        assert(!consumedItems.equals(expectedItems));
        Collections.sort(consumedItems);
        assert(consumedItems.equals(expectedItems));
    }
}
