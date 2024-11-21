package com.dsa.heap;

import java.util.*;

public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] arr = {8, 10, 7, 8, 11, 30, 11, 8, 38, 11, 2, 45, 2, 8};
        int K = 4;
        var ans = topKFrequentElementUsingMaxHeap(arr, K);
        System.out.println(ans);
        ans = topKFrequentElementUsingMinHeap(arr, K);
        System.out.println(ans);
    }

    // TC: O(N) + (K * log N), SC: O(N)
    private static List<Map.Entry<Integer, Integer>> topKFrequentElementUsingMaxHeap(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        // O(N)
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // max-heap
        Queue<Map.Entry<Integer, Integer>> PQ =
                new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        // O(N)
        PQ.addAll(map.entrySet());

        List<Map.Entry<Integer, Integer>> ans = new ArrayList<>();
        // K * log N
        for (int i = 0; i < K; i++) {
            ans.add(PQ.poll());
        }
        return ans;
    }

    // TC: N log K
    private static List<Map.Entry<Integer, Integer>> topKFrequentElementUsingMinHeap(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // max-heap
        Queue<Map.Entry<Integer, Integer>> PQ =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer,Integer> entrySet : map.entrySet()){
            // till K size add into PQ
            // K log K
            if(PQ.size() < K){
                PQ.add(entrySet);
            } else {
                // (N-K) log K
                // once K size exceeds, check coming frq is greater than root
                if(!PQ.isEmpty() && entrySet.getValue() > PQ.peek().getValue()){
                    PQ.poll();
                    PQ.add(entrySet);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> ans = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            ans.add(PQ.poll());
        }
        return ans;
    }
}
