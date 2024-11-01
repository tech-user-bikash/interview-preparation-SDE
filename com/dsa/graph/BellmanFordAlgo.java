package com.dsa.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm
// https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=41
public class BellmanFordAlgo {
    public static void main(String[] args) {
        int V = 2, src = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>());
        edges.get(0).add(0);
        edges.get(0).add(1);
        edges.get(0).add(9);

        var ans = bellmanFord(V, edges, src);
        System.out.println(Arrays.toString(ans));
    }

    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] distArr = new int[V];
        Arrays.fill(distArr, (int) 1e8);
        distArr[src] = 0;

        // TC: O(V X E)
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (distArr[u] != (int) 1e8 && distArr[u] + wt < distArr[v]) {
                    distArr[v] = distArr[u] + wt;
                }
            }
        }

        // Nth relaxation to check -ve cycle
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if (distArr[u] != (int) 1e8 && distArr[u] + wt < distArr[v]) {
                return new int[]{-1};
            }
        }

        return distArr;
    }
}
