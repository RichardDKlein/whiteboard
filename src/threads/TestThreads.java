package threads;

public final class TestThreads {
    private TestThreads() {}

    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("                   THREADS                   ");
        System.out.println("=============================================");

        ProducerConsumerQueue.test();
    }
}
