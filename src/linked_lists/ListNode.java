package linked_lists;

/**
 * Represent a node in a linked list.
 */
public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(T data) {
        this.data = data;
    }
}
