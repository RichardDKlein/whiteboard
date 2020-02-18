package com.whiteboard.lists;

/**
 * Delete a node from a singly-linked list, given only a pointer
 * to the node to be deleted.
 */
public class DeleteNode<E> {
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
    public boolean deleteNode(ListNode<E> victim) {
        ListNode<E> next = victim.next;
        if (next == null) {
            return false;
        }
        victim.data = next.data;
        victim.next = next.next;
        return true;
    }
}
