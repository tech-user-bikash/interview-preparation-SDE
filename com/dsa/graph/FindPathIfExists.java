package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPathIfExists {

    public static void main(String[] args) {
        int[][] A = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int N = 3;
        boolean pathExists = isPathExists(A, N, 0, 2);
        System.out.println(pathExists);
    }

    private static boolean isPathExists(int[][] A, int n, int src, int dest) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        ArrayList<Integer>[] graphArr = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
            graphArr[i] = new ArrayList<>();
        }
        for (int[] aa : A) {
            graph.get(aa[0]).add(aa[1]);
            graph.get(aa[1]).add(aa[0]);
            graphArr[aa[0]].add(aa[1]);
            graphArr[aa[1]].add(aa[0]);
        }
        System.out.println(graph);
        System.out.println(Arrays.toString(graphArr));
//        System.out.println(graph.size());
//        List<Integer>[] graph = new ArrayList[n];
//        Arrays.fill(graph, new ArrayList<Integer>());
//        System.out.println(Arrays.toString(graph));
//        for(int i = 0; i<n; i++){
////            graph[i].get();
//        }


        return false;
    }


}
