package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/prerequisite-tasks/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prerequisite-tasks
public class CourseSchedule_I {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        CourseSchedule_I courseScheduleI = new CourseSchedule_I();
        var ans = courseScheduleI.isPossible(4, 3, prerequisites);
        if(ans){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] inDegree = new int[N];
        // calculate inDegree
        for (ArrayList<Integer> list : adj) {
            for (int i : list) {
                inDegree[i]++;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        // for all 0's inDegree push into Q
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                Q.add(i);
            }
        }

        int countTopoSort = 0;
        // traverse Q
        while (!Q.isEmpty()) {
            int node = Q.poll();
            countTopoSort++;
            // traverse neighbours
            for (int n : adj.get(node)) {
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    Q.add(n);
                }
            }
        }
        if (countTopoSort == N) return true;
        return false;
    }
}
