package com.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapApp {
    public static void main(String[] args) {
        HeapApp heap = new HeapApp();
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        heap.buildMaxHeap(arr);
    }

    private void buildMinHeap(int[] arr) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i : arr){
            PQ.add(i);
            System.out.println(PQ.peek());
        }
    }

    private void buildMaxHeap(int[] arr) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            PQ.add(i);
            System.out.println(PQ.peek());
        }
    }
}
