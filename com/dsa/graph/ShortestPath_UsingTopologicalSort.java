package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=direct-acyclic-graph
// https://www.youtube.com/watch?v=ZUFQfFaU-8U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=27
public class ShortestPath_UsingTopologicalSort {
    static class Pair {
        int node;
        int weight;

        Pair(int _n, int _wt) {
            this.node = _n;
            this.weight = _wt;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int V = 6, E = 7;
        var ans = shortestPath(V, E, edges);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // step-1: TopoSort
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        // O(V + E)
        // for all component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, st);
            }
        }

        //step-2, create a distance array and relax the edges from the stack
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // add source distance as 0. because src->src == 0
        distance[0] = 0;

        // O(V(Stack all elements + E(all the edges for each stack node. i.e. in total no of edges which is E)))
        while (!st.isEmpty()) {
            int node = st.pop();
            // make sure unvisited component not be part of distance calculation
            if (distance[node] == Integer.MAX_VALUE) {
                distance[node] = -1;
                continue;
            }
            // visit neighbours
            for (Pair p : adj.get(node)) {
                int n = p.node;
                int wt = p.weight;
                // source distance + current weight < current distance, update the current distance.
                if (distance[node] + wt < distance[n]) {
                    distance[n] = distance[node] + wt;
                }
            }
        }

        return distance;
    }

    private static void dfs(int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        // visit neighbours
        for (Pair p : adj.get(node)) {
            if (!visited[p.node]) {
                dfs(p.node, adj, visited, st);
            }
        }
        // push into stack after traversal of it's all neighbour nodes
        st.push(node);

    }
}
