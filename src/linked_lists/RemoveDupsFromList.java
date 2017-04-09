package linked_lists;

import java.util.HashSet;

/**
 * Remove duplicates from a linked list.
 */
public class RemoveDupsFromList<T> {
    private ListNode<T> head;

    public RemoveDupsFromList(ListNode<T> head) {
        this.head = head;
    }

    public void compute() {
        HashSet<T> seen = new HashSet<>();
        ListNode<T> prev = null;
        ListNode<T> curr = head;
        while (curr != null) {
            if (seen.contains(curr.data)) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                seen.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public static void test() {
        System.out.println();
        System.out.println("Test removeDupsFromList():");
        System.out.println("==========================");

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
        ListNode<Character> eNode = new AppendToList(head, e).compute();
        ListNode<Character> fNode = new AppendToList(head, f).compute();
        new AppendToList(head, g).compute();
        TestUtils testUtils = new TestUtils(head);
        testUtils.printList();

        new InsertInList(cNode, a).compute();
        new InsertInList(eNode, b).compute();
        new InsertInList(fNode, d).compute();
        new AppendToList(head, c).compute();
        new AppendToList(head, e).compute();
        new AppendToList(head, g).compute();
        testUtils.printList();

        new RemoveDupsFromList(head).compute();
        System.out.println("Removing duplicates:");
        testUtils.printList();
    }
}
