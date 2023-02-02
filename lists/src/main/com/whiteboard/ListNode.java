package com.whiteboard;

public class ListNode<E> {
    E data;
    ListNode<E> next;

    ListNode(E data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListNode<?> other)) {
            return false;
        }
        return this.data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
