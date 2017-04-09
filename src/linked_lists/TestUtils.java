package linked_lists;

/**
 * Test utilities for the linked_lists package.
 */
public class TestUtils<T> {
    private ListNode<T> head;

    public TestUtils(ListNode<T> head) {
        this.head = head;
    }

    public void printList() {
        ListNode<T> curr = head;
        boolean atHead = true;
        while (curr != null) {
            if (!atHead) {
                System.out.print("->");
            } else {
                atHead = false;
            }
            System.out.print(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public void printList(int max) {
        ListNode<T> curr = head;
        int count = 0;
        boolean atHead = true;
        while ((curr != null) && (count < max)) {
            if (!atHead) {
                System.out.print("->");
            } else {
                atHead = false;
            }
            System.out.print(curr.data);
            curr = curr.next;
            ++count;
        }
        System.out.println();
    }
}
