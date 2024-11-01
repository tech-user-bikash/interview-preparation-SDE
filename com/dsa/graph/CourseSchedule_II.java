package com.dsa.graph;

import java.util.*;

// https://www.geeksforgeeks.org/problems/prerequisite-tasks/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prerequisite-tasks
public class CourseSchedule_II {
    public static void main(String[] args) {
//        int[][] prerequisites = {
//                {1, 0},
//                {2, 0},
//                {3, 1},
//                {3, 2}};
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        for(int i = 0; i<4; i++ ){
            prerequisites.add(new ArrayList<>());
        }
        prerequisites.get(0).add(1);
        prerequisites.get(0).add(0);
        prerequisites.get(1).add(2);
        prerequisites.get(1).add(0);
        prerequisites.get(2).add(3);
        prerequisites.get(2).add(1);
        prerequisites.get(3).add(3);
        prerequisites.get(3).add(2);

        CourseSchedule_II courseScheduleII = new CourseSchedule_II();
        var ans = courseScheduleII.findOrder(4, 4, prerequisites);
        System.out.println(Arrays.toString(ans));
    }

    private int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> prerequisite : prerequisites) {
            adj.get(prerequisite.get(1)).add(prerequisite.get(0));
        }

        int[] inDegree = new int[n];
        // calculate inDegree
        for (ArrayList<Integer> list : adj) {
            for (int i : list) {
                inDegree[i]++;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        // for all 0's inDegree push into Q
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                Q.add(i);
            }
        }

        List<Integer> topoSortList = new ArrayList<>();
        // traverse Q
        while (!Q.isEmpty()) {
            int node = Q.poll();
            topoSortList.add(node);
            // traverse neighbours
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    Q.add(it);
                }
            }
        }
        if (topoSortList.size() == n) return topoSortList.stream().mapToInt(Integer::intValue).toArray();
        return new int[]{};
    }
}
