package lists;

/**
 * Find the kth to last element in a singly-linked list.
 */
public class KthToLastInList {
    private KthToLastInList() {}

    /**
     * Find the kth to last element in a singly-linked list.
     *
     * @param head The list of interest.
     * @param k A positive integer.
     * @return The kth to last element in the list,
     * or null if the list does not contain k elements.
     */
    public static <E> ListNode<E> kthToLastInList(ListNode<E> head, int k) {
        ListNode<E> lead = head;
        int count = 0;
        while ((lead != null) && (count < k)) {
            lead = lead.next;
            ++count;
        }
        if (count < k) {
            return null;
        }
        ListNode<E> lag = head;
        while (lead != null) {
            lead = lead.next;
            lag = lag.next;
        }
        return lag;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test KthToLastInList:");
        System.out.println("=====================");

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

        for (int k = 1; k <= 8; ++k) {
            ListNode<Character> kthToLast = kthToLastInList(aNode, k);
            System.out.println("kth to last element (k = " + k + ") is " +
                    ((kthToLast != null) ? kthToLast.data : "undefined"));
        }
    }
}
