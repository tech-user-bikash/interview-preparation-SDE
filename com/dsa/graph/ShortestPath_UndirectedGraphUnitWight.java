package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath_UndirectedGraphUnitWight {
    public static void main(String[] args) {
        int n= 4, m = 2, src = 3;
        int[][] edges = {{1,3},{3,0}};
        var ans = shortestPath(edges, n, m, src);
        System.out.println(Arrays.toString(ans));
    }
    // TC: O(V + 2E)
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        //Create an adjacency list of size N for storing the undirected graph.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //A dist array of size N initialised with a large number to
        //indicate that initially all the nodes are untraveled.
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        // BFS Implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int it : adj.get(node)) {
                if(dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }
        // Updated the shortest distances are stored in the resultant array ‘ans’.
        // Unreachable nodes are marked as -1.
        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
