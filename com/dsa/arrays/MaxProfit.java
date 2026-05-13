package com.dsa.arrays;

import java.util.*;

class MaxProfit {
    public static void main(String[] args) {
        MaxProfit pf = new MaxProfit();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        pf.MaximumNonOverlappingIntervals(intervals);


        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 9, 7, 9, 3};
        int n = start.length;
        List<int[]> meetings = new ArrayList<>();
        for(int i = 0; i<n; i++){
            meetings.add(new int[]{start[i], end[i]});
        }
       meetings.sort(Comparator.comparingInt(a -> a[1]));
        for(int[] meet : meetings){
            System.out.println(Arrays.toString(meet));
        }


        int[][] jobs = { {1,4,20}, {2,1,10}, {3,1,40}, {4,1,30} };
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        for(int[] j : jobs){
            System.out.println(Arrays.toString(j));
        }

        pf.JobScheduling(jobs);
    }
    public int[] JobScheduling(int[][] Jobs) {
        List<Job> jobList = new ArrayList<>();
        for (int[] job : Jobs) {
            jobList.add(new Job(job[0], job[1], job[2]));
        }
        Collections.sort(jobList);
        System.out.println(jobList);
        return null;
    }

    public int MaximumNonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int limit = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] > limit){
                count++;
                limit = intervals[i][1];
            }
        }
        System.out.println(intervals.length+"-->"+count);
        return count;
    }
}

class Job implements Comparable<Job> {
    int id;
    int deadline;
    int profit;

    public Job(int _id, int _deadLine, int _pf) {
        this.id = _id;
        this.deadline = _deadLine;
        this.profit = _pf;
    }

    @Override
    public int compareTo(Job j) {
        // Compare based on profit
        return Integer.compare(j.profit, this.profit);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}
