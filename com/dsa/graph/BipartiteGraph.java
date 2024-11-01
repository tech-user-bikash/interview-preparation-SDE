package com.dsa.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph
public class BipartiteGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            BipartiteGraph obj = new BipartiteGraph();
            boolean ans = obj.isBipartite(V, adj);
            if (ans)
                System.out.println("1");
            else System.out.println("0");
        }
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            // for every component check
            if (color[i] == -1) {
                // if(!checkBfs(i, V, adj, color)){
                //     return false;
                // }
                if (!checkDfs(i, 0, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDfs(int node, int srcColor, ArrayList<ArrayList<Integer>> adj, int[] color) {
        color[node] = srcColor;
        for (int n : adj.get(node)) {
            if (color[n] == -1) {
                if (!checkDfs(n, 1 - srcColor, adj, color)) {
                    return false;
                }
            } else if (color[node] == color[n]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBfs(int src, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        // initial color
        color[src] = 0;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int node : adj.get(currNode)) {
                // check for adjacent node if not colored yet
                if (color[node] == -1) {
                    // opposite color 1 / 0
                    color[node] = 1 - color[currNode];
                    queue.add(node);
                }
                // if already colored and same color
                if (color[node] == color[currNode]) {
                    return false;
                }
            }
        }

        return true;
    }
}
