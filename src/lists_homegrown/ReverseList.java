package lists_homegrown;

/**
 * Reverse a linked-list
 */
public class ReverseList {
    private ReverseList() {}

    /**
     * Reverses a singly-linked list
     *
     * @param head The head node of the list to be reversed.
     * @return The head node of the reversed list.
     */
    public static <E> ListNode<E> reverseList(ListNode<E> head) {
        ListNode<E> rev = null;
        ListNode<E> curr = head;
        while (curr != null) {
            ListNode<E> next = curr.next;
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

        ListNode<Character> aNode = new ListNode<>();
        ListNode<Character> bNode = new ListNode<>();
        ListNode<Character> cNode = new ListNode<>();
        ListNode<Character> dNode = new ListNode<>();
        ListNode<Character> eNode = new ListNode<>();
        ListNode<Character> fNode = new ListNode<>();
        ListNode<Character> gNode = new ListNode<>();

        aNode.data = 'a'; aNode.next = bNode;
        bNode.data = 'b'; bNode.next = cNode;
        cNode.data = 'c'; cNode.next = dNode;
        dNode.data = 'd'; dNode.next = eNode;
        eNode.data = 'e'; eNode.next = fNode;
        fNode.data = 'f'; fNode.next = gNode;
        gNode.data = 'g'; gNode.next = null;

        ListNode<Character> list = aNode;
        System.out.println("Original list:");
        TestUtils.printList(list);

        ListNode<Character> rev = reverseList(list);
        System.out.println("\nReversed list:");
        TestUtils.printList(rev);
    }
}
