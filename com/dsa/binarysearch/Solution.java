package com.dsa.binarysearch;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {7, 1, 5, 3, 6, 4};

        // Create an instance of Solution class
        Solution sol = new Solution();

        // Call the stockBuySell function and print the result
        System.out.println("The maximum profit that can be generated is " + sol.stockBuySell(arr, n));
    }

    public int stockBuySell(int[] arr, int n) {
        int[][] dp = new int[n][2];
        for(int[] A : dp) Arrays.fill(A, -1);
        return getMaxProfit(0, 0, arr, dp);
    }

    private int getMaxProfit(int idx, int buy, int[] arr, int[][] dp){
        // base case
        if(idx == arr.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];
        // explore all the paths
        int profit = 0;
        // current stock buy
        if(buy == 0) {
            int take = -arr[idx] + getMaxProfit(idx + 1, 1, arr, dp);
            // can buy in next day
            int notTake = getMaxProfit(idx + 1, 0, arr, dp);
            profit = Math.max(take, notTake);
        }
        if(buy == 1) {
            int take = arr[idx] + getMaxProfit(idx + 1, 0, arr, dp);
            // can buy in next day
            int notTake = getMaxProfit(idx + 1, 1, arr, dp);
            profit = Math.max(take, notTake);
        }
        return dp[idx][buy] = profit;
    }
}

