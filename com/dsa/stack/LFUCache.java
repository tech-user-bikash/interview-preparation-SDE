package com.dsa.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LFU = Least Frequently Used
 */
public class LFUCache {
    private static int CAPACITY;
    private int minFreq;
    private int currSize;
    Map<Integer, Deque<LFUNode>> freqMap;
    Map<Integer, LFUNode> cacheMap;

    /**
     * Initialize the default values of LFU Cache properties.
     *
     * @param CAPACITY: total capacity of LFU cache.
     * @param minFreq:  frequency of the last linked list(the minimum frequency of entire LFU cache).
     * @param currSize: current size of LFU cache.
     * @param freqMap:  map that has key to node mapping, which used for storing all nodes by their keys
     * @param cacheMap: map that has key to doubly linked list mapping, which used for storing all the nodes by their frequencies.
     */
    public LFUCache(int size) {
        CAPACITY = size;
        minFreq = 0;
        currSize = 0;

        freqMap = new HashMap<>();
        cacheMap = new HashMap<>();
    }

    /**
     * get node value by key, and then update node freq as well as relocate that node.
     */
    public LFUNode getItem(int key) {
        // if cache not having for given input, return -1
        if (!cacheMap.containsKey(key)) {
            return new LFUNode(-1, -1);
        }
        var node = cacheMap.get(key);
        // increase the freq
        updateNode(node);
        return node;

    }

    private void updateNode(LFUNode node) {
        // get the freq and based on that remove from DLL.
        int currFreq = node.freq;
        var deque = freqMap.get(currFreq);
        deque.remove(node);

        // if curr DLL is last which has low frequency and curr node is the only node in that DLL,
        // then we need to remove entire DLL and increase minFreq by 1.
        if (currFreq == minFreq && deque.isEmpty()) {
            minFreq++;
        }

        // increase the freq of given node, add into freq map
        node.freq++;
        Deque<LFUNode> newDeque = freqMap.getOrDefault(node.freq, new LinkedList<>());
        newDeque.addFirst(node);
        freqMap.put(node.freq, newDeque);
    }

    /**
     * Add New node into cache as well as into freq map.
     * condition-1: if cache has the input key, update the node value and position in DLL.
     * condition-2: if cache doesn't have input key,
     *              2.1: if cache is full, remove the least recently used node in minimum freq list, then add new node.
     *              2.2: if cache has space, add new node in front of DLL.
     */

    public void putItem(int key, int value){
        if(CAPACITY == 0) return;

        if(cacheMap.containsKey(key)){
            var lfuNode = cacheMap.get(key);
            lfuNode.value = value;
            updateNode(lfuNode);
        } else {
            currSize++;
            if(currSize > CAPACITY){
                // get min freq list
                var deque = freqMap.get(minFreq);
                cacheMap.remove(deque.getLast().key);
                deque.removeLast();
                currSize--;
            }
            // reset min freq to 1 because of adding new node.
            minFreq = 1;
            var newNode = new LFUNode(key, value);
            newNode.freq = 1;

            // get list with freq 1, and then add new node into this list as well as int cache.
            var newDeque = freqMap.getOrDefault(1, new LinkedList<>());
            newDeque.addFirst(newNode);
            freqMap.put(1, newDeque);
            cacheMap.put(key, newNode);
        }


    }
}

class LFUNode {
    int key;
    int value;
    int freq;

    LFUNode(int K, int V) {
        this.key = K;
        this.value = V;
        freq = 0;
    }

    @Override
    public String toString() {
        return "LFUNode{" +
                "key=" + key +
                ", value=" + value +
                ", freq=" + freq +
                '}';
    }
}
