package com.dsa.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Fibonacci {
    public static void main(String[] args) {
        var ans = getNthFibonacci(4);
//        System.out.println(ans);
    }

    private static int getNthFibonacci(int N) {
        int prev = 0, next = 1;
        for (int i = 2; i <= N; i++) {
            System.out.print(next + " ");
            int curr = prev + next;
            prev = next;
            next = curr;

        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = {1, 2, 4, 4};
        for (int i : nums) {
//             if(map.containsKey(i)){
//                 map.put(i, map.get(i)+1);
//             } else {
//                 map.put(i, 1);
//             }
            map.merge(i, 1, Integer::sum);
        }
        var list = map.entrySet().stream().filter(entry -> entry.getValue() > nums.length / 2)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.print(map);

//        System.out.print(next+" ");
        return next;
    }
}
