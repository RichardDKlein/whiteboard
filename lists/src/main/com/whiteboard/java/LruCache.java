package com.whiteboard.java;

import java.util.*;

/**
 * Implement an LRU (Least-Recently Used) Cache.
 *
 * The LRU eviction strategy is implemented using a doubly-linked
 * list of cache keys. Whenever a value is read from or written to
 * the cache, its key is moved to the front of the list. Therefore,
 * at any point in the time, the key at the tail of the list is the
 * least-recently used one.
 *
 * Each cache entry contains not just the cached value, but also a
 * reference to the corresponding node in the LRU list. Thus, accessing
 * the LRU list node for a given cache key is an O(1) operation.
 */
public final class LruCache<K, V> {
    static class ListNode<K> {
        K key;
        ListNode<K> prev;
        ListNode<K> next;

        ListNode(K key) {
            this.key = key;
        }
    }

    static class LruLinkedList<K> {
        ListNode<K> head;
        ListNode<K> tail;

        void remove(ListNode<K> listNode) {
            if (head == listNode && tail == listNode) {
                head = tail = null;
            } else if (head == listNode) {
                head = listNode.next;
                listNode.next.prev = null;
            } else if (tail == listNode) {
                tail = listNode.prev;
                listNode.prev.next = null;
            } else {
                listNode.prev.next = listNode.next;
                listNode.next.prev = listNode.prev;
            }
        }

        void insertAtHead(ListNode<K> listNode) {
            if (head == null) {
                head = tail = listNode;
                listNode.prev = listNode.next = null;
            } else {
                listNode.prev = null;
                listNode.next = head;
                head.prev = listNode;
                head = listNode;
            }
        }

        ListNode<K> removeFromTail() {
            ListNode<K> tailNode = tail;
            tail = tailNode.prev;
            tailNode.prev.next = null;
            return tailNode;
        }
    }

    static class CacheNode<K, V> {
        V value;
        ListNode<K> listNode;

        CacheNode(V value, ListNode<K> listNode) {
            this.value = value;
            this.listNode = listNode;
        }
    }

    int capacity;
    Map<K, CacheNode<K, V>> cache;
    LruLinkedList<K> lruList;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        lruList = new LruLinkedList<>();
    }

    public V get(K key) {
        CacheNode<K, V> cacheNode = cache.get(key);
        lruList.remove(cacheNode.listNode);
        lruList.insertAtHead(cacheNode.listNode);
        return cacheNode.value;
    }

    public void put(K key, V value) {
        if (cache.size() == capacity) {
            evictLeastRecentlyUsed();
        }
        ListNode<K> listNode = new ListNode<>(key);
        CacheNode<K, V> cacheNode = new CacheNode<>(value, listNode);
        cache.put(key, cacheNode);
        lruList.insertAtHead(listNode);
    }

    private void evictLeastRecentlyUsed() {
        ListNode<K> lruNode = lruList.removeFromTail();
        cache.remove(lruNode.key);
    }
}
