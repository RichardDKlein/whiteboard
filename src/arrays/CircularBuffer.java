package arrays;

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
    int[] buffer;
    int head;
    int tail;

    public CircularBuffer(int length) {
        this.buffer = new int[length];
        this.head = 0;
        this.tail = 0;
    }
    public void add(int n) {
        if (isFull()) {
            System.out.println("FULL!");
        } else {
            this.buffer[tail] = n;
            tail = (tail + 1) % this.buffer.length;
        }
    }
    public int remove() {
        if (isEmpty()) {
            System.out.println("EMPTY!");
            return -1;
        } else {
            int element = this.buffer[head];
            head = (head + 1) % this.buffer.length;
            return element;
        }
    }
    private boolean isFull() {
        return (tail + 1) % this.buffer.length == head;
    }
    private boolean isEmpty() {
        return head == tail;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test CircularBuffer():");
        System.out.println("======================");

        System.out.println("Create a CircularBuffer of length 10");
        CircularBuffer buf = new CircularBuffer(10);
        System.out.println("Add five elements");
        buf.add(1);
        buf.add(2);
        buf.add(3);
        buf.add(4);
        buf.add(5);
        System.out.println("Remove five elements:");
        for (int i = 0; i < 5; ++i) {
            System.out.print(buf.remove() + " ");
        }
        System.out.println();
        System.out.println("Add five more elements");
        buf.add(6);
        buf.add(7);
        buf.add(8);
        buf.add(9);
        buf.add(10);
        System.out.println("Remove five elements:");
        for (int i = 0; i < 5; ++i) {
            System.out.print(buf.remove() + " ");
        }
        System.out.println();
        System.out.println("Add five more elements");
        buf.add(11);
        buf.add(12);
        buf.add(13);
        buf.add(14);
        buf.add(15);
        System.out.println("Remove five elements:");
        for (int i = 0; i < 5; ++i) {
            System.out.print(buf.remove() + " ");
        }
        System.out.println();
        System.out.println("Add ten elements");
        buf.add(1);
        buf.add(2);
        buf.add(3);
        buf.add(4);
        buf.add(5);
        buf.add(6);
        buf.add(7);
        buf.add(8);
        buf.add(9);
        buf.add(10);
        System.out.println("Remove ten elements:");
        for (int i = 0; i < 10; ++i) {
            System.out.print(buf.remove() + " ");
        }
        System.out.println();
    }
}