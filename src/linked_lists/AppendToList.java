package linked_lists;

/**
 * Append a data item to a linked list.
 */
public class AppendToList<T> {
    private ListNode<T> head;
    T data;

    public AppendToList(ListNode<T> head, T data) {
        this.head = head;
        this.data = data;
    }

    public ListNode<T> compute() {
        ListNode<T> prev = null;
        ListNode<T> curr = head;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        ListNode<T> node = new ListNode<>(data);
        prev.next = node;
        return node;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test appendToList():");
        System.out.println("====================");

        char a = 'a';
        char b = 'b';
        char c = 'c';
        char d = 'd';
        char e = 'e';
        char f = 'f';
        char g = 'g';

        ListNode<Character> head = new ListNode(a);
        TestUtils<Character> testUtils = new TestUtils<>(head);
        testUtils.printList();

        new AppendToList(head, b).compute();
        testUtils.printList();

        new AppendToList(head, c).compute();
        testUtils.printList();

        new AppendToList(head, d).compute();
        testUtils.printList();

        new AppendToList(head, e).compute();
        testUtils.printList();

        new AppendToList(head, f).compute();
        testUtils.printList();

        new AppendToList(head, g).compute();
        testUtils.printList();
    }
}
