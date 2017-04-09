package linked_lists;

/**
 * Reverse a linked list.
 */
public class ReverseList<T> {
    private ListNode<T> head;

    public ReverseList(ListNode<T> head) {
        this.head = head;
    }

    /**
     * @return Head of reversed list.
     */
    public ListNode<T> compute() {
        ListNode<T> rev = null;
        ListNode<T> curr = head;
        while (curr != null) {
            ListNode<T> next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
        }
        return rev;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test reverseList():");
        System.out.println("===================");

        char a = 'a';
        char b = 'b';
        char c = 'c';
        char d = 'd';
        char e = 'e';
        char f = 'f';
        char g = 'g';

        ListNode<Character> head = new ListNode<>(a);
        new AppendToList(head, b).compute();
        new AppendToList(head, c).compute();
        new AppendToList(head, d).compute();
        new AppendToList(head, e).compute();
        new AppendToList(head, f).compute();
        new AppendToList(head, g).compute();
        new TestUtils(head).printList();

        ListNode<Character> rev = new ReverseList(head).compute();
        new TestUtils(rev).printList();

        ListNode<Character> orig = new ReverseList(rev).compute();
        new TestUtils(orig).printList();
    }
}
