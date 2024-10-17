package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
    /** Function to convert given matrix to adjacency list graph */
    public ArrayList<ArrayList<Integer>> createAdjList(int[][] matrix, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] A : matrix){
            adjList.get(A[0]).add(A[1]);
            adjList.get(A[1]).add(A[0]);
        }
        return adjList;
    }

    /** Function to return Breadth First Traversal of given graph.*/
    // TC: O(N) + O(2E-degree of node)
    // SC: ~O(3N)
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        // add source node
        q.add(0);
        // visit first node
        visited[0] = true;

        // traver until Queue is empty O(N)
        while(!q.isEmpty()){
            // remove first node from Queue
            Integer node = q.poll();
            // add into the ans
            ans.add(node);
            // traverse all the adjacent nodes. O(2E)
            for(int n : adj.get(node)){
                // check if it is visited or not
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
        return ans;
    }


    // TC: O(N+2E) , SC: O(3N) one more for recursive stack
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int N = adj.size();
        // SC: O(N)
        ArrayList<Integer> ans = new ArrayList<>();
        // SC: O(N)
        boolean[] visited = new boolean[N];

        for(int i = 0; i<N; i++) {
            if(!visited[i]){
                dfs(adj, i, visited, ans);
            }
        }
        return ans;
    }

    // TC : O(N)
    private void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, ArrayList<Integer> ans){
        ans.add(src);
        visited[src] = true;
        // TC: O(2*E(degree of graph/node))
        for(int node : adj.get(src)){
            if(!visited[node]){
                dfs(adj, node, visited, ans);
            }
        }
    }
}
