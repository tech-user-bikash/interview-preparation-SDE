package com.dsa.graph;

import java.util.ArrayList;
import java.util.Stack;

// https://www.youtube.com/watch?v=5lZ0iJMrUMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21
// https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
public class TopologicalSort {
    public static void main(String[] args) {

    }
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        // initial config
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        // visit for every component
        for(int i = 0; i<adj.size(); i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }

        // add into ans list from stack
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        // visit neighbours
        for(int n : adj.get(node)){
            if(!visited[n]){
                dfs(n, adj, visited, stack);
            }
        }
        // push into stack once traverse completed for a node
        stack.push(node);
    }
}
