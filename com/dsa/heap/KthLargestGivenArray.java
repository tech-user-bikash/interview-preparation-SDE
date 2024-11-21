package com.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestGivenArray {
    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        int K = 3;
        int val = findKthLargestValueUsingMaxHeap(arr, K);
        System.out.println(val);
        val = findKthLargestValueUsingMinHeap(arr, K);
        System.out.println(val);

    }

    // SC : O(K), TC : O(N-K) log K(heap is K size)
    private static int findKthLargestValueUsingMinHeap(int[] arr, int k) {
        if (arr.length < k) {
            return -1;
        }
        Queue<Integer> PQ = new PriorityQueue<>();
        // K log K
        for (int i = 0; i < k; i++) {
            PQ.add(arr[i]);
        }

        // (N-K) log K - bcz heap is size k
        for (int i = k; i < arr.length; i++) {
            if (!PQ.isEmpty() && arr[i] > PQ.peek()) {
                PQ.poll();
                PQ.add(arr[i]);
            }
        }

        return PQ.size() > 0 ? PQ.peek() : -1;

    }

    // SC: O(N), TC : K log N
    private static int findKthLargestValueUsingMaxHeap(int[] arr, int k) {
        if (arr.length < k) {
            return -1;
        }
        Queue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

        // log N
        for (int i : arr) {
            PQ.add(i);
        }
        // K log N
        for (int i = 0; i < k - 1; i++) {
            PQ.poll();
        }

        return PQ.size() > 0 ? PQ.peek() : -1;
    }
}
