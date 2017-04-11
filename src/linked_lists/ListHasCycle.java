package linked_lists;

/**
 * Determine whether a linked list contains a cycle.
 */
public class ListHasCycle<T> {
    private ListNode<T> head;

    public ListHasCycle(ListNode<T> head) {
        this.head = head;
    }

    /**
     * @return true if list contains a cycle, false otherwise.
     */
    public boolean compute() {
        ListNode<T> slow = head;
        ListNode<T> fast = (head != null) ? head.next : null;
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = (fast.next != null) ? fast.next.next : null;
        }
        return false;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test listHasCycle():");
        System.out.println("====================");

        char a = 'a';
        char b = 'b';
        char c = 'c';
        char d = 'd';
        char e = 'e';
        char f = 'f';
        char g = 'g';

        ListNode<Character> head = new ListNode<>(a);
        new AppendToList(head, b).compute();
        ListNode<Character> cNode = new AppendToList(head, c).compute();
        new AppendToList(head, d).compute();
        new AppendToList(head, e).compute();
        new AppendToList(head, f).compute();
        ListNode<Character> gNode = new AppendToList(head, g).compute();
        TestUtils testUtils = new TestUtils(head);
        testUtils.printList();
        System.out.println("Has cycle = " + new ListHasCycle(head).compute());

        gNode.next = cNode;
        testUtils.printList(22);
        System.out.println("Has cycle = " + new ListHasCycle(head).compute());
    }
}
