package com.dsa.graph;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
// https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=45
public class MST {
    static class Pair {
        int node, distance;

        Pair(int _n, int _d) {
            this.node = _n;
            this.distance = _d;
        }
    }

    public static void main(String[] args) {

    }

    // TC : O(E log E) = E log E(all edges removing from PQ) + E log E(all edges push into PQ)
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        Queue<Pair> PQ = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        PQ.add(new Pair(0, 0));

        boolean[] visited = new boolean[V];
        int sum = 0;

        // E
        while (!PQ.isEmpty()) {
            // log E
            Pair p = PQ.poll();
            // skip, if already visited
            if (visited[p.node]) {
                continue;
            }
            visited[p.node] = true;
            sum += p.distance;

            // log E
            for (int[] A : adj.get(p.node)) {
                int n = A[0];
                int wt = A[1];
                if (!visited[n]) {
                    PQ.add(new Pair(n, wt));
                }
            }
        }
        return sum;
    }
}
