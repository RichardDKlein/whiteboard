package lists_homegrown;

/**
 * Test utilities for the lists_homegrown package.
 */
public class TestUtils {
    private TestUtils() {}

    public static <T> void printList(ListNode<T> head) {
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

    public static <T> void printList(ListNode<T> head, int max) {
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
