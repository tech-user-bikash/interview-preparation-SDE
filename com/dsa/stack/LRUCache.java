package com.dsa.stack;

import java.util.*;

/**
 * LRU = Least Recently Used
 */
public class LRUCache {
    private static int CACHE_SIZE;
    Map<Integer, LRUNode> map;
    Deque<LRUNode> deque;

    LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        this.map = new HashMap<>(capacity);
        deque = new LinkedList<>();
    }

    // 1. put operation
    public void put(int key, int value) {
        // 1. if already present, update it
        if (map.containsKey(key)) {
            // remove LRUNode
            deque.remove(map.get(key));
        }
        // 2. Cache full, new element came, remove last and add new one to front
        if (map.size() == CACHE_SIZE) {
            // remove LRUNode
            deque.removeLast();
        }
        // 3. insert LRUNode at first
        var newLRUNode = new LRUNode(key, value);
        deque.addFirst(newLRUNode);
        map.put(key, newLRUNode);

    }

    // 2. get operation, if not found return -1
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        var LRUNode = map.get(key);
        deque.remove(LRUNode);
        deque.addFirst(LRUNode);
        return LRUNode.value;
    }
}

class LRUNode {
    int key;
    int value;

    LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
