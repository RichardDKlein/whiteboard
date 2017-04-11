package linked_lists;

/**
 * Find the kth to last node in a linked list.
 */
public class KthToLastInList<T> {
    private ListNode<T> head;
    private int k;

    public KthToLastInList(ListNode<T> head, int k) {
        this.head = head;
        this.k = k;
    }

    /**
     * @return Kth to last node in list, or null if k is too big.
     */
    public ListNode<T> compute() {
        ListNode<T> lead = head;
        int count = 0;
        while ((lead != null) && (count < k)) {
            lead = lead.next;
            ++count;
        }
        if (count < k) {
            return null;
        }
        ListNode<T> lag = head;
        while (lead != null) {
            lead = lead.next;
            lag = lag.next;
        }
        return lag;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test kthToLastInList():");
        System.out.println("=======================");

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

        for (int k = 1; k <= 8; ++k) {
            ListNode<Character> kthToLastNode =
                new KthToLastInList(head, k).compute();
            System.out.println("kth to last element (k = " + k + ") is "
                + ((kthToLastNode != null) ? kthToLastNode.data : "null"));
        }
    }
}
