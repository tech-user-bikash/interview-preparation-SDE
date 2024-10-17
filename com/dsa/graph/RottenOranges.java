package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/rotten-oranges2536/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotten_oranges
public class RottenOranges {
    static class Pair {
        int row;
        int col;
        int time;

        Pair(int _r, int _c, int _t) {
            this.row = _r;
            this.col = _c;
            this.time = _t;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        RottenOranges oranges = new RottenOranges();
        var ans = oranges.orangesRotting(grid);
        System.out.println(ans);
    }

    // TC: O(N*M), SC: O(N*M)
    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[row][col];

        // add the rotten oranges into queue
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        // 4 direction
        int[] deltaRow = {-1, 0, +1, 0};
        int[] deltaCol = {0, +1, 0, -1};
        int totalTime = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            // 4 direction check
            for (int i = 0; i < 4; i++) {
                int nRow = pair.row + deltaRow[i];
                int nCol = pair.col + deltaCol[i];
                int time = pair.time;
                totalTime = Math.max(time, totalTime);
                // boundary check
                if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col
                        && grid[nRow][nCol] == 1) {
                    queue.add(new Pair(nRow, nCol, time + 1));
                    grid[nRow][nCol] = 2;
                }
            }
        }

        for (int[] nums : grid) {
            for (int j = 0; j < col; j++) {
                if (nums[j] == 1) {
                    return -1;
                }
            }
        }
        return totalTime;
    }
}
