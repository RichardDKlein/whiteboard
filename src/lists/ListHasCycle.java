package lists;

/**
 * Determine whether a singly-linked list contains a cycle.
 */
public class ListHasCycle {
    private ListHasCycle() {}

    /**
     * Determine whether a singly-linked list contains a cycle.
     *
     * Our algorithm is the classic approach utilizing two
     * pointers to iterate thru the list: A slow pointer, which
     * iterates by one list element at a time; and a fast pointer,
     * which iterates by two list elements at a time. If the fast
     * pointer ever "laps" the slow pointer, then the list contains
     * a cycle.
     *
     * @param head The list of interest
     * @return A boolean indicating whether or not
     * the specified list contains a cycle.
     */
    public static <E> boolean listHasCycle(ListNode<E> head) {
        ListNode<E> slow = head;
        ListNode<E> fast = (head != null) ? head.next : null;
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = (fast.next != null) ? fast.next.next : null;
        }
        return false;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test ListHasCycle:");
        System.out.println("==================");

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

        TestUtils.printList(aNode);

        System.out.println("Has cycle = " + listHasCycle(aNode));

        gNode.next = cNode;
        TestUtils.printList(aNode, 22);
        System.out.println("Has cycle = " + listHasCycle(aNode));
    }
}
