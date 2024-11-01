package com.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-multiplications-to-reach-end
// https://www.youtube.com/watch?v=_BvEJ3VIDWw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=39
public class Multiplication_Minimum_Steps_To_Reach_End {
    static class Pair {
        int node, steps;

        Pair(int _n, int _s) {
            this.node = _n;
            this.steps = _s;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int start = 7, end = 66175;
        var ans = minimumMultiplications(arr, start, end);
        System.out.println(ans);
    }

    // TC: O(100000 * N) -- Hypothetically this much
    static int minimumMultiplications(int[] arr, int start, int end) {

        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(start, 0));

        int[] distArr = new int[100000];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[start] = 0;

        int c=0;
        while (!Q.isEmpty()) {
            c++;
            System.out.print(c+" ");
            Pair p = Q.poll();
            if (p.node == end) return p.steps;
            for (int n : arr) {
                int num = (p.node * n) % 100000;
                if (p.steps + 1 < distArr[num]) {
                    distArr[num] = p.steps + 1;
                    Q.add(new Pair(num, distArr[num]));
                }
            }
        }
        return -1;
    }
}
