package com.dsa.stack;

import java.util.*;

public class LRUCache {
    private static int CACHE_SIZE;
    Map<Integer, Node> map;
    Deque<Node> deque;

    LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        this.map = new HashMap<>(capacity);
        deque = new LinkedList<>();
    }

    // 1. put operation
    public void put(int key, int value) {
        // to update an existing node
         if(!deque.isEmpty() && deque.size() <= CACHE_SIZE && !map.isEmpty()
                 && map.get(key) != null && map.get(key).key == key){
             var node = map.get(key);
             deque.remove(node);
             node.value = value;
             deque.addFirst(node);
             map.put(key, node);
         } else {
             // if queue is empty, put in front
             var newNode = new Node(key, value);
             if (deque.size() >= CACHE_SIZE) {
                 deque.removeLast();
             }
             deque.addFirst(newNode);
             map.put(key, newNode);
         }


    }

    // 2. get operation, if not found return -1
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        var node = map.get(key);
        deque.remove(node);
        deque.addFirst(node);
        return node.value;
    }
}

class Node {
    int key;
    int value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
