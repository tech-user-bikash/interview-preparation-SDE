package com.dsa.graph;

import java.util.ArrayList;

public class Province {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 3;
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(1);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(2).add(0);
        adj.get(2).add(1);

        var ans = numProvinces(adj, V);
        System.out.println(ans);


    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<V; i++){
            for(int j = 0; j<V; j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        System.out.println(graph);
        boolean[] visited = new boolean[V];
        int ans = 0;
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                ans++;
                dfs(graph, i, visited);
            }
        }
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited){
        visited[src] = true;

        for(int node : graph.get(src)){
            if(!visited[node]){
                dfs(graph, node, visited);
            }
        }
    }
}
