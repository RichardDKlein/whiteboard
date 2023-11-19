package com.whiteboard.java;

import java.util.*;

/**
 * Implement an LRU (Least-Recently Used) Cache
 */
public final class LruCache<K, V> {
    private static class LruListNode<K> {
        K key;
        LruListNode<K> next;
        LruListNode<K> prev;

        LruListNode(K key) {
            this.key = key;
        }
    }

    private static class LruLinkedList<K> {
        LruListNode<K> head;
        LruListNode<K> tail;

        void addFirst(LruListNode<K> lruListNode) {
            if (head == null) {
                head = tail = lruListNode;
                lruListNode.next = lruListNode.prev = null;
            } else {
                LruListNode<K> oldHead = head;
                head = lruListNode;
                lruListNode.next = oldHead;
                lruListNode.prev = null;
            }
        }

        void remove(LruListNode<K> lruListNode) {
            if (head == lruListNode && tail == lruListNode) {
                head = tail = null;
            } else if (head == lruListNode) {
                head = lruListNode.next;
            } else if (tail == lruListNode) {
                tail = lruListNode.prev;
            } else {
                LruListNode<K> prev = lruListNode.prev;
                LruListNode<K> next = lruListNode.next;
                prev.next = next;
                next.prev = prev;
            }
            lruListNode.next = lruListNode.prev = null;
        }

        LruListNode<K> removeLast() {
            LruListNode<K> last = tail;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = last.prev;
            }
            last.next = last.prev = null;
            return last;
        }
    }

    private static class CacheNode<K, V> {
        V value;
        LruListNode<K> lruListNode;

        CacheNode(V value, LruListNode<K> lruListNode) {
            this.value = value;
            this.lruListNode = lruListNode;
        }
    }

    private final int capacity;
    private final Map<K, CacheNode<K, V>> cache;
    private final LruLinkedList<K> lruLinkedList;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        lruLinkedList = new LruLinkedList<>();
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            evictLeastRecentlyUsed();
        }
        LruListNode<K> lruListNode = new LruListNode<>(key);
        CacheNode<K, V> cacheNode = new CacheNode<>(value, lruListNode);
        cache.put(key, cacheNode);
        lruLinkedList.addFirst(lruListNode);
    }

    public V get(K key) {
        CacheNode<K, V> cacheNode = cache.get(key);
        LruListNode<K> lruListNode = cacheNode.lruListNode;
        lruLinkedList.remove(lruListNode);
        lruLinkedList.addFirst(lruListNode);
        return cache.get(key).value;
    }

    private void evictLeastRecentlyUsed() {
        LruListNode<K> lruListNode = lruLinkedList.removeLast();
        cache.remove(lruListNode.key);
    }
}
