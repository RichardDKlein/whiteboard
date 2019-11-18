package stacks_and_queues;

public final class TestStacksAndQueues {
    private TestStacksAndQueues() {}
    public static void run() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("              STACKS AND QUEUES              ");
        System.out.println("=============================================");

        BalancedBrackets.test();
        QueueUsingTwoStacks.test();
        ReversePolish.test();
    }
}
