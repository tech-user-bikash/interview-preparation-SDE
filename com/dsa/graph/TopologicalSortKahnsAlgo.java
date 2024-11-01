package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortKahnsAlgo {
    // TC: O(V + E)
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> topoSort = new ArrayList<>();
        int V = adj.size();
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        // calculate in-degree for each node
        for (ArrayList<Integer> integers : adj) {
            for (int n : integers) {
                indegree[n]++;
            }
        }

        // traverse in-degree and push the degree 0 into queue
        for(int i = 0; i<V; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            // removed node from queue will add into topological sort list
            topoSort.add(node);

            // visit neighbours
            for(int n : adj.get(node)){
                // decrease the in-degree for each neighbour
                indegree[n]--;
                // after decrease if it becomes 0, push into the queue
                if(indegree[n] == 0){
                    queue.add(n);
                }

            }
        }
        return topoSort;
    }
}
