package com.dsa.heap;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 1, 88, 8, 11, 30, 11, 8, 38, 11, 2, 45, 2, 8};
        var ans = sortElementsByFrequencyUsingMaxHeap(arr);
        System.out.println(ans);

    }

    // TC: O(N) + (K * log N), SC: O(N)
    private static List<Map.Entry<Integer, Integer>> sortElementsByFrequencyUsingMaxHeap(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        // O(N)
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // max-heap
        Queue<Map.Entry<Integer, Integer>> PQ =
                new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        // N log N
        PQ.addAll(map.entrySet());

        return PQ.stream().toList();
    }
}
