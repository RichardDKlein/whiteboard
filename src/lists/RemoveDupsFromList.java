package lists;

import java.util.HashSet;

/**
 * Remove duplicates from a singly-linked list.
 */
public class RemoveDupsFromList {
    private RemoveDupsFromList() {}

    /**
     * Remove duplicates from a singly-linked list.
     * @param head The list of interest.
     */
    public static <E> void removeDupsFromList(ListNode<E> head) {
        HashSet<E> seen = new HashSet<>();
        ListNode<E> prev = null;
        ListNode<E> curr = head;
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
        System.out.println("Test RemoveDupsFromList:");
        System.out.println("========================");

        ListNode<Character> a1Node = new ListNode<>();
        ListNode<Character> b1Node = new ListNode<>();
        ListNode<Character> c1Node = new ListNode<>();
        ListNode<Character> a2Node = new ListNode<>();
        ListNode<Character> d1Node = new ListNode<>();
        ListNode<Character> e1Node = new ListNode<>();
        ListNode<Character> b2Node = new ListNode<>();
        ListNode<Character> fNode = new ListNode<>();
        ListNode<Character> d2Node = new ListNode<>();
        ListNode<Character> g1Node = new ListNode<>();
        ListNode<Character> c2Node = new ListNode<>();
        ListNode<Character> e2Node = new ListNode<>();
        ListNode<Character> g2Node = new ListNode<>();

        a1Node.data = 'a'; a1Node.next = b1Node;
        b1Node.data = 'b'; b1Node.next = c1Node;
        c1Node.data = 'c'; c1Node.next = a2Node;
        a2Node.data = 'a'; a2Node.next = d1Node;
        d1Node.data = 'd'; d1Node.next = e1Node;
        e1Node.data = 'e'; e1Node.next = b2Node;
        b2Node.data = 'b'; b2Node.next = fNode;
        fNode.data = 'f'; fNode.next = d2Node;
        d2Node.data = 'd'; d2Node.next = g1Node;
        g1Node.data = 'g'; g1Node.next = c2Node;
        c2Node.data = 'c'; c2Node.next = e2Node;
        e2Node.data = 'e'; e2Node.next = g2Node;
        g2Node.data = 'g'; g2Node.next = null;

        TestUtils.printList(a1Node);
        System.out.println("Removing duplicates:");
        removeDupsFromList(a1Node);
        TestUtils.printList(a1Node);
    }
}
