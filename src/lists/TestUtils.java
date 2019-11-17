package lists;

/**
 * Test utilities for the lists package.
 */
public class TestUtils {
    private TestUtils() {}

    static <E> void printList(ListNode<E> head) {
        if (head == null) {
            System.out.println("<empty>");
            return;
        }
        ListNode<E> curr = head;
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

    static <E> void printList(ListNode<E> head, int max) {
        if (head == null) {
            System.out.println("<empty>");
            return;
        }
        ListNode<E> curr = head;
        boolean atHead = true;
        int count = 0;
        while (curr != null) {
            if (!atHead) {
                System.out.print("->");
            } else {
                atHead = false;
            }
            System.out.print(curr.data);
            if (++count >= max) {
                System.out.print("-> ...");
                break;
            }
            curr = curr.next;
        }
        System.out.println();
    }
}
