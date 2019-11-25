package lists;

/**
 * Reverse a singly-linked list in place, using a recursive
 * approach.
 */
public class ReverseListRecursive {
    private ReverseListRecursive() {}

    /**
     * Reverse a singly-linked list in place, using a recursive
     * approach.
     *
     * @param head The head node of the list to be reversed.
     * @return The head node of the reversed list.
     */
    public static <E> ListNode<E> reverseListRecursive(ListNode<E> head) {
        if (head == null) {
            return null;
        }
        ListNode<E> nodeAfterHead = head.next;
        ListNode<E> rev = reverseListRecursive(nodeAfterHead);
        if (rev == null) {
            return head;
        }
        ListNode<E> curr = rev;
        while (curr.next != null) {
            curr = curr.next;
        }
        ListNode<E> tail = curr;
        tail.next = head;
        head.next = null;
        return rev;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ReverseListRecursive:");
        System.out.println("==========================");

        ListNode<Character> list = null;
        System.out.println("Original list:");
        TestUtils.printList(list);
        ListNode<Character> rev = reverseListRecursive(list);
        System.out.println("\nReversed list:");
        TestUtils.printList(rev);

        ListNode<Character> aNode = new ListNode<>();
        ListNode<Character> bNode = new ListNode<>();
        ListNode<Character> cNode = new ListNode<>();
        ListNode<Character> dNode = new ListNode<>();
        ListNode<Character> eNode = new ListNode<>();
        ListNode<Character> fNode = new ListNode<>();
        ListNode<Character> gNode = new ListNode<>();

        aNode.data = 'a';
        bNode.data = 'b';
        cNode.data = 'c';
        dNode.data = 'd';
        eNode.data = 'e';
        fNode.data = 'f';
        gNode.data = 'g';

        aNode.next = null;
        list = aNode;
        System.out.println("\nOriginal list:");
        TestUtils.printList(list);
        rev = reverseListRecursive(list);
        System.out.println("\nReversed list:");
        TestUtils.printList(rev);

        aNode.next = bNode;
        bNode.next = cNode;
        cNode.next = dNode;
        dNode.next = eNode;
        eNode.next = fNode;
        fNode.next = gNode;
        gNode.next = null;
        list = aNode;
        System.out.println("\nOriginal list:");
        TestUtils.printList(list);
        rev = reverseListRecursive(list);
        System.out.println("\nReversed list:");
        TestUtils.printList(rev);
    }
}
