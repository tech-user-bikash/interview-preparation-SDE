package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUndirectedGraph {
    static class Pair {
        int src;
        int parent;

        Pair(int _src, int _parent) {
            this.src = _src;
            this.parent = _parent;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(1);
        adj.get(4).add(3);

        CycleDetectionUndirectedGraph graph = new CycleDetectionUndirectedGraph();
        System.out.println(graph.isCycle(adj));
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i] && bfs(i, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        // go to all adjacent nodes
        for (int adjacentNode : adj.get(node)) {
            if (!visited[adjacentNode]) {
                if (dfs(adjacentNode, node, adj, visited))
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if (adjacentNode != parent) return true;
        }
        return false;
    }

    private boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        visited[src] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int adjNode : adj.get(pair.src)) {
                if (!visited[adjNode]) {
                    queue.add(new Pair(adjNode, pair.src));
                    visited[adjNode] = true;
                } else if (pair.parent != adjNode) {
                    return true;
                }

            }
        }
        return false;
    }
}
