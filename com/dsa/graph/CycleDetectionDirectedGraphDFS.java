package com.dsa.graph;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph
public class CycleDetectionDirectedGraphDFS {

    // take visited & path visited array to track, it can be possible using single array as well.
    // use 0 - not visit, 1 - visit, 2 - path visit
    // Function to detect cycle in a directed graph.
    // TC: (V+E)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        // each component check
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                        boolean[] pathVisited){
        visited[node] = true;
        pathVisited[node] = true;

        // visit neighbour nodes
        for(int n : adj.get(node)){
            // when node is not visited.
            if(!visited[n]){
                if(dfs(n, adj, visited, pathVisited)){
                    return true;
                }
            }
            // node has previously visited, but it has to be visited on the same path.
            else if(pathVisited[n]){
                return true;
            }
        }
        // remove the path visit array while going back from traversal
        pathVisited[node] = false;
        return false;
    }
}
