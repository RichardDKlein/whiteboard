package linked_lists;

/**
 * Delete a node from a linked list, given
 * only a pointer to the node to be deleted.
 */
public class DeleteFromList<T> {
    private ListNode<T> toDelete;

    public DeleteFromList(ListNode<T> toDelete) {
        this.toDelete = toDelete;
    }

    /**
     * @return true if the node was successfully deleted,
     * false otherwise. (Will return false only if the
     * node is at the end of the list.)
     */
    public boolean compute() {
        ListNode<T> next = toDelete.next;
        if (next == null) {
            return false;
        }
        toDelete.data = next.data;
        toDelete.next = next.next;
        return true;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test deleteFromList():");
        System.out.println("======================");

        char a = 'a';
        char b = 'b';
        char c = 'c';
        char d = 'd';
        char e = 'e';
        char f = 'f';
        char g = 'g';
        char x = 'x';

        ListNode<Character> head = new ListNode<>(a);
        new AppendToList(head, b).compute();
        new AppendToList(head, c).compute();
        ListNode<Character> dNode = new AppendToList(head, d).compute();
        new AppendToList(head, e).compute();
        new AppendToList(head, f).compute();
        new AppendToList(head, g).compute();
        TestUtils testUtils = new TestUtils(head);
        testUtils.printList();

        ListNode<Character> xNode = new InsertInList(dNode, x).compute();
        testUtils.printList();

        new DeleteFromList(xNode).compute();
        testUtils.printList();
    }
}
