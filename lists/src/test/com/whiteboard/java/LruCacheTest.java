package com.whiteboard.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LruCacheTest {
    @Test
    public void lruCacheTest() {
        System.out.println();
        System.out.println("Test LruCache:");
        System.out.println("==============");

        int capacity = 10;
        LruCache<String, String> lruCache = new LruCache<>(capacity);
        System.out.println("put 0 thru 9:");
        lruCache.put("0", "zero");
        lruCache.put("1", "one");
        lruCache.put("2", "two");
        lruCache.put("3", "three");
        lruCache.put("4", "four");
        lruCache.put("5", "five");
        lruCache.put("6", "six");
        lruCache.put("7", "seven");
        lruCache.put("8", "eight");
        lruCache.put("9", "nine");

        assert("9->8->7->6->5->4->3->2->1->0".equals(lruCache.lruLinkedListToString()));
        System.out.println(lruCache.lruLinkedListToString());

        System.out.println("\nput 10:");
        lruCache.put("10", "ten");
        assert("10->9->8->7->6->5->4->3->2->1".equals(lruCache.lruLinkedListToString()));
        System.out.println(lruCache.lruLinkedListToString());

        String value = lruCache.get("6");
        assert("six".equals(value));
        System.out.printf("\nlruCache.get(\"6\") = %s\n", value);
        assert("6->10->9->8->7->5->4->3->2->1".equals(lruCache.lruLinkedListToString()));
        System.out.println(lruCache.lruLinkedListToString());

        value = lruCache.get("2");
        assert("two".equals(value));
        System.out.printf("\nlruCache.get(\"2\") = %s\n", value);
        assert("2->6->10->9->8->7->5->4->3->1".equals(lruCache.lruLinkedListToString()));
        System.out.println(lruCache.lruLinkedListToString());

        value = lruCache.get("1");
        assert("one".equals(value));
        System.out.printf("\nlruCache.get(\"1\") = %s\n", value);
        assert("1->2->6->10->9->8->7->5->4->3".equals(lruCache.lruLinkedListToString()));
        System.out.println(lruCache.lruLinkedListToString());

        value = lruCache.get("1");
        assert("one".equals(value));
        System.out.printf("\nlruCache.get(\"1\") = %s\n", value);
        assert("1->2->6->10->9->8->7->5->4->3".equals(lruCache.lruLinkedListToString()));
        System.out.println(lruCache.lruLinkedListToString());

        System.out.println("\nput 11:");
        lruCache.put("11", "eleven");
        assert("11->1->2->6->10->9->8->7->5->4".equals(lruCache.lruLinkedListToString()));
        System.out.println(lruCache.lruLinkedListToString());
    }
}
