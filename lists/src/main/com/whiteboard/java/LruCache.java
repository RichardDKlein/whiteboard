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
    static class LruListNode<K> {
        K key;
        LruListNode<K> next;
        LruListNode<K> prev;

        LruListNode(K key) {
            this.key = key;
        }
    }

    static class LruLinkedList<K> {
        LruListNode<K> head;
        LruListNode<K> tail;

        void addFirst(LruListNode<K> lruListNode) {
            if (head == null) {
                head = tail = lruListNode;
                lruListNode.next = lruListNode.prev = null;
            } else {
                lruListNode.next = head;
                head.prev = lruListNode;
                head = lruListNode;
                lruListNode.prev = null;
            }
        }

        void remove(LruListNode<K> lruListNode) {
            if (head == lruListNode && tail == lruListNode) {
                head = tail = null;
            } else if (head == lruListNode) {
                head = lruListNode.next;
                lruListNode.next.prev = null;
            } else if (tail == lruListNode) {
                tail = lruListNode.prev;
                lruListNode.prev.next = null;
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
            tail = last.prev;
            last.prev.next = null;
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
    final LruLinkedList<K> lruLinkedList;

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
        return cacheNode.value;
    }

    private void evictLeastRecentlyUsed() {
        LruListNode<K> lruListNode = lruLinkedList.removeLast();
        cache.remove(lruListNode.key);
    }
}
