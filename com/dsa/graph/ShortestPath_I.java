package com.dsa.graph;

import java.util.*;

public class ShortestPath_I {

    static class Pair {
        int node, distance;

        Pair(int _n, int _d) {
            this.node = _n;
            this.distance = _d;
        }
    }

    private void dijkstra(List<List<Pair>> adjList, int srcNode, int[] distArr, int[] parentArr) {
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        pq.add(new Pair(srcNode, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.distance;
            // visit neighbours
            for (Pair p : adjList.get(node)) {
                if (p.distance + dist < distArr[p.node]) {
                    distArr[p.node] = p.distance + dist;
                    parentArr[p.node] = node;
                    pq.add(new Pair(p.node, distArr[p.node]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        ShortestPath_I shortestPath = new ShortestPath_I();
        var ans = shortestPath.shortestPath(n, m, edges);
        System.out.println(ans);
    }

    // TC: O(E log V) + O(N)
//    public List<Integer> shortestPath(int n, int m, int edges[][]) {
//
//        List<List<int[]>> ars = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            ars.add(new ArrayList<>());
//        }
//
//        for (int[] edge : edges) {
//            int start = edge[0];
//            int end = edge[1];
//            int weight = edge[2];
//
//            ars.get(start).add(new int[]{end, weight});
//            ars.get(end).add(new int[]{start, weight});
//        }
//
//        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//        int[] dist = new int[n + 1];
//        int[] prev = new int[n + 1];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Arrays.fill(prev, -1);
//        dist[1] = 0;
//
//        q.offer(new int[]{1, 0});
//
//        while (!q.isEmpty()) {
//
//            int[] previous = q.poll();
//            int prevStart = previous[0];
//            int prevDist = previous[1];
//
//            for (int[] current : ars.get(prevStart)) {
//                int end = current[0];
//                int currentWeight = current[1];
//
//                if (dist[end] > prevDist + currentWeight) {
//                    dist[end] = prevDist + currentWeight;
//                    prev[end] = prevStart;
//                    q.offer(new int[]{end, dist[end]});
//                }
//
//            }
//        }
//        List<Integer> ans = new ArrayList<>();
//
//        if (dist[n] == Integer.MAX_VALUE) {
//            ans.add(-1);
//            return ans;
//        }
//
//        // TC: O(N)
//        for (int at = n; at != -1; at = prev[at]) {
//            ans.add(at);
//        }
//        Collections.reverse(ans);
//        ans.add(0, dist[n]);
//        return ans;
//    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, wt));
        }

        int[] distArr = new int[n + 1];
        // set initial parent as itself
        int[] parentArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parentArr[i] = i;
            distArr[i] = (int) 1e9;
        }
        distArr[1] = 0;
        // apply dijkstra algo
        dijkstra(adjList, 1, distArr, parentArr);

        List<Integer> ans = new ArrayList<>();
        if (distArr[n] == (int) 1e9) {
            ans.add(-1);
            return ans;
        }

        // get the path from last node to first
        int node = n;
        while (parentArr[node] != node) {
            ans.add(node);
            node = parentArr[node];
        }
        ans.add(node);
        Collections.reverse(ans);
        ans.add(0, distArr[n]);

        return ans;
    }
}
