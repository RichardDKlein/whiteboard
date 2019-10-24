package lists;

/**
 * Delete a node from a singly-linked list, given only a pointer
 * to the node to be deleted.
 */
public class DeleteNode {
    private static ListNode<Character> aNode = new ListNode<>();
    private static ListNode<Character> bNode = new ListNode<>();
    private static ListNode<Character> cNode = new ListNode<>();
    private static ListNode<Character> dNode = new ListNode<>();
    private static ListNode<Character> eNode = new ListNode<>();
    private static ListNode<Character> fNode = new ListNode<>();
    private static ListNode<Character> gNode = new ListNode<>();

    private DeleteNode() {}

    /**
     * Delete a node from a singly-linked list, given only a
     * pointer to the node to be deleted.
     *
     * This seemingly impossible feat is accomplished by copying
     * the next node into the node to be deleted, effectively
     * deleting the latter.
     *
     * Of course, this will only work if there IS a next node,
     * i.e. if the node to be deleted is not the last node in
     * the list.
     *
     * @param victim The node to be deleted.
     * @return A boolean indicating whether or not the deletion
     * was successful.
     */
    public static <T> boolean deleteNode(ListNode<T> victim) {
        ListNode<T> next = victim.next;
        if (next == null) {
            return false;
        }
        victim.data = next.data;
        victim.next = next.next;
        return true;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test deleteNode():");
        System.out.println("==================");

        System.out.println("\nOriginal list:");
        ListNode<Character> list = createTestList();
        TestUtils.printList(list);

        System.out.println("\nDeleting Node 'a':");
        boolean result = deleteNode(aNode);
        TestUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'b':");
        list = createTestList();
        result = deleteNode(bNode);
        TestUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'c':");
        list = createTestList();
        result = deleteNode(cNode);
        TestUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'd':");
        list = createTestList();
        result = deleteNode(dNode);
        TestUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'e':");
        list = createTestList();
        result = deleteNode(eNode);
        TestUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'f':");
        list = createTestList();
        result = deleteNode(fNode);
        TestUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");

        System.out.println("\nDeleting Node 'g':");
        list = createTestList();
        result = deleteNode(gNode);
        TestUtils.printList(list);
        System.out.println(result ? "SUCCESS" : "FAILURE");
    }

    private static ListNode<Character> createTestList() {
        aNode.data = 'a'; aNode.next = bNode;
        bNode.data = 'b'; bNode.next = cNode;
        cNode.data = 'c'; cNode.next = dNode;
        dNode.data = 'd'; dNode.next = eNode;
        eNode.data = 'e'; eNode.next = fNode;
        fNode.data = 'f'; fNode.next = gNode;
        gNode.data = 'g'; gNode.next = null;

        return aNode;
    }
}
