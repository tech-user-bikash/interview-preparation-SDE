package com.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestGivenStreamOfNumbers {
    // Max heap
    static Queue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        int K = 3;

        // from a data stream each time add a value into PQ, return the kth largest element
        for(int i : arr){
            int topVal = insert(i, K);
            System.out.println(topVal);
        }

    }

    // SC : O(K), TC : O(N-K) log K(heap is K size)
    private static int insert(int val, int k) {
        // till k size add into PQ and return peek value once it reaches kth size
        if(PQ.size() < k){
           PQ.add(val);
           return PQ.size() == k ? PQ.peek() : -1;
        }

        // once min heap exceeds the size
        // remove top and add the new element, if it is less than top element
        if(!PQ.isEmpty() && val < PQ.peek()){
            PQ.poll();
            PQ.add(val);
        }
        return PQ.size() != 0 ? PQ.peek() : -1;
    }


}
