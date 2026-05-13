package com.dsa.dp;

import java.util.Arrays;

public class KnapsackTest {
    public static void main(String[] args) {
        KnapsackTest test = new KnapsackTest();
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int W = 50;
        var ans = test.knapsack01(wt, val, wt.length, W);
        System.out.println(ans);
    }

    public int knapsack01(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        // fill first row with values
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int cap = 0; cap <= W; cap++) {
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= cap) {
                    pick = val[i] + dp[i - 1][cap - wt[i]];
                }
                int notPick = dp[i - 1][cap];
                // Update the DP table
                dp[i][cap] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][W];
    }

    private int getMaxWeight(int idx, int[] wt, int[] val, int W, int[][] dp) {
        // at last index
        if (idx == 0) {
            if (wt[idx] <= W) return val[idx];
            return 0;
        }
        if (dp[idx][W] != -1) return dp[idx][W];

        int pick = Integer.MIN_VALUE;
        if (wt[idx] <= W) {
            pick = val[idx] + getMaxWeight(idx - 1, wt, val, W - wt[idx], dp);
        }
        int notPick = getMaxWeight(idx - 1, wt, val, W, dp);

        return dp[idx][W] = Math.max(pick, notPick);
    }
}
