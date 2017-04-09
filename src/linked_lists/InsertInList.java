package linked_lists;

import bit_manipulation.*;

/**
 * Insert an item in a linked list,
 * after a specified list node.
 */
public class InsertInList<T> {
    private ListNode<T> after;
    private T data;

    public InsertInList(ListNode<T> after, T data) {
        this.after = after;
        this.data = data;
    }

    /**
     * @return New list node containing inserted data item.
     */
    ListNode<T> compute() {
        ListNode<T> node = new ListNode<>(data);
        node.next = after.next;
        after.next = node;

        return node;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test insertInList():");
        System.out.println("====================");

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

        new InsertInList(dNode, x).compute();
        testUtils.printList();
    }
}
