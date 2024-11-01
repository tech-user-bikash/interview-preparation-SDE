package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class EnclavesCount {
    static class Pair {
        int row;
        int col;

        Pair(int _r, int _c) {
            this.row = _r;
            this.col = _c;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        EnclavesCount enclavesCount = new EnclavesCount();
        var ans = enclavesCount.numberOfEnclaves(grid);
        System.out.println(ans);
    }

    // TC: O(N * M), count no of land which will not able to connect boundary
    int numberOfEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // first & last row, first & last col
                if (!visited[i][j] && (i == 0 || i == r - 1 || j == 0 || j == c - 1) && grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                }
            }
        }

        // 4 direction move
        int[] delR = {-1, 0, +1, 0};
        int[] delC = {0, +1, 0, -1};

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            // move 4 directions
            for (int i = 0; i < 4; i++) {
                int nRow = p.row + delR[i];
                int nCol = p.col + delC[i];
                // boundary check
                if (nRow >= 0 && nRow < r && nCol >= 0 && nCol < c &&
                        !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    queue.add(new Pair(nRow, nCol));
                }
            }
        }

        // check and count unvisited 1's which will consider as a land
        int landCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    landCount++;
                }
            }
        }
        return landCount;

    }
}
