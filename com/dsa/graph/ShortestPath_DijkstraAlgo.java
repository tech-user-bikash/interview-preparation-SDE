package com.dsa.graph;

import java.util.*;

// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-dijkstra-set-1-adjacency-matrix
// https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=32
public class ShortestPath_DijkstraAlgo {
    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int V = 3, src = 2;
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.println(adj);
        adj.get(0).add(new iPair(1, 1));
        adj.get(0).add(new iPair(2, 6));

        adj.get(1).add(new iPair(2, 3));
        adj.get(1).add(new iPair(0, 1));

        adj.get(2).add(new iPair(1, 3));
        adj.get(2).add(new iPair(0, 6));

        ShortestPath_DijkstraAlgo dij = new ShortestPath_DijkstraAlgo();
        var ans = dij.dijkstra(adj, src);
        System.out.println(ans);
    }

    // TC: E log V where E = total no of edges, V = total no of nodes
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        Queue<iPair> Q = new PriorityQueue<>(Comparator.comparingInt(x -> x.second));
        // add source node with 0 weight
        Q.add(new iPair(src, 0));
        // create distance list and ad source node's distance
        ArrayList<Integer> distanceList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            distanceList.add((int) 1e9);
        }
        distanceList.set(src, 0);

        while (!Q.isEmpty()) {
            iPair pair = Q.poll();
            int node = pair.first;
            int dist = pair.second;

            for (iPair p : adj.get(node)) {
                int adjNode = p.first;
                int adjDist = p.second;
                int newDist = dist + adjDist;
                if (newDist < distanceList.get(adjNode)) {
                    distanceList.set(adjNode, newDist);
                    Q.add(new iPair(adjNode, distanceList.get(adjNode)));
                }
            }
        }
        return distanceList;
    }
}
