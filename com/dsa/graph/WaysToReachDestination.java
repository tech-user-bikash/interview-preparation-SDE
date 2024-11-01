package com.dsa.graph;

import java.util.*;

// https://www.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=%2Fnumber-of-ways-to-arrive-at-destination
// https://www.youtube.com/watch?v=_-0mx0SmYxA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42
public class WaysToReachDestination {
    static class Pair {
        int node;
        long dist;

        Pair(int _n, long _d) {
            this.node = _n;
            this.dist = _d;
        }
    }

    public static void main(String[] args) {
        int n = 6, m = 8;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        edges.get(0).add(0);
        edges.get(0).add(1);
        edges.get(0).add(1000000000);

        edges.get(1).add(0);
        edges.get(1).add(3);
        edges.get(1).add(1000000000);

        edges.get(2).add(1);
        edges.get(2).add(3);
        edges.get(2).add(1000000000);

        edges.get(3).add(1);
        edges.get(3).add(2);
        edges.get(3).add(1000000000);

        edges.get(4).add(1);
        edges.get(4).add(5);
        edges.get(4).add(1000000000);

        edges.get(5).add(3);
        edges.get(5).add(4);
        edges.get(5).add(1000000000);

        edges.get(6).add(4);
        edges.get(6).add(5);
        edges.get(6).add(1000000000);

        edges.get(7).add(2);
        edges.get(7).add(5);
        edges.get(7).add(1000000000);

        int ans = countPaths(n, edges);
        System.out.println(ans);
    }

    // TC: E Log V
    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> road : roads) {
            int u = road.get(0);
            int v = road.get(1);
            int time = road.get(2);
            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }

        long[] distArr = new long[n];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[0] = 0;
        int[] waysArr = new int[n];
        waysArr[0] = 1;
        int mod = (int) (1e9 + 7);

        Queue<Pair> PQ = new PriorityQueue<>((x, y) -> Long.compare(x.dist, y.dist));
        PQ.add(new Pair(0, 0));

        while (!PQ.isEmpty()) {
            Pair p = PQ.poll();
            // visit neighbours
            for (Pair pair : adj.get(p.node)) {
                int adjNode = pair.node;
                long adjDist = pair.dist;
                // first time reaches with shrot distance
                if (p.dist + adjDist < distArr[adjNode]) {
                    distArr[adjNode] = p.dist + adjDist;
                    PQ.add(new Pair(adjNode, distArr[adjNode]));
                    waysArr[adjNode] = waysArr[p.node];
                }
                // already visited
                else if (p.dist + adjDist == distArr[adjNode]) {
                    waysArr[adjNode] = (waysArr[p.node] + waysArr[adjNode]) % mod;
                }
            }
        }
        return waysArr[n - 1] % mod;
    }
}
