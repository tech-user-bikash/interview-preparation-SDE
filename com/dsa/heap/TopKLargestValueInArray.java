package com.dsa.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class TopKLargestValueInArray {
    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        int K = 3;
        int[] val = topKthLargestValuesUsingMaxHeap(arr, K);
        System.out.println(Arrays.toString(val));
        val = topKthLargestValuesUsingMinHeap(arr, K);
        System.out.println(Arrays.toString(val));

    }

    // SC : O(K), TC : O(N-K) log K(heap is K size)
    private static int[] topKthLargestValuesUsingMinHeap(int[] arr, int k) {
        if (arr.length < k) {
            return new int[]{-1};
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

        return PQ.stream().mapToInt(i->i).toArray();

    }

    // SC: O(N), TC : K log N
    private static int[] topKthLargestValuesUsingMaxHeap(int[] arr, int k) {
        if (arr.length < k) {
            return new int[]{-1};
        }
        Queue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

        // log N
        for (int i : arr) {
            PQ.add(i);
        }
        int[] ans = new int[k];
        // K log N
        for (int i = 0; i < k && !PQ.isEmpty(); i++) {
            ans[i] = PQ.poll();
        }
        return ans;
    }
}
