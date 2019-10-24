package lists;

/**
 * Test utilities for the lists package.
 */
public class TestUtils {
    private TestUtils() {}

    static <T> void printList(ListNode<T> head) {
        if (head == null) {
            System.out.println("<empty>");
            return;
        }
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

    static <T> void printList(ListNode<T> head, int max) {
        if (head == null) {
            System.out.println("<empty>");
            return;
        }
        ListNode<T> curr = head;
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
