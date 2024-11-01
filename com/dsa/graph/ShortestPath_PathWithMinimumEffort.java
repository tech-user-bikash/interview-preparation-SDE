package com.dsa.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath_PathWithMinimumEffort {
    static class Pair {
        int row;
        int col;
        int distDiff;

        Pair(int _r, int _c, int _d) {
            this.row = _r;
            this.col = _c;
            this.distDiff = _d;
        }
    }

    public static void main(String[] args) {
        int row = 3, columns = 3;
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int ans = minimumEffort(row, columns, heights);
        System.out.println(ans);
    }

    // TC: E log V
    //     (r * c * 4) * log (r * c)
    public static int minimumEffort(int rows, int columns, int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        Queue<Pair> PQ = new PriorityQueue<>(Comparator.comparingInt(x -> x.distDiff));
        PQ.add(new Pair(0, 0, 0));

        int[][] distArr = new int[r][c];
        for (int[] A : distArr) {
            Arrays.fill(A, (int) 1e9);
        }
        distArr[0][0] = 0;

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!PQ.isEmpty()) {
            Pair p = PQ.poll();

            // if destination reached, return the diff
            if (p.row == rows - 1 && p.col == columns - 1) return p.distDiff;
            // visit 4 directions
            for (int i = 0; i < 4; i++) {
                int nRow = p.row + delRow[i];
                int nCol = p.col + delCol[i];

                // check boundaries of new row & col
                if (nRow >= 0 && nRow < r && nCol >= 0 && nCol < c) {
                    int newEffort = Math.max(
                            Math.abs(heights[p.row][p.col] - heights[nRow][nCol]),
                            p.distDiff);
                    if (newEffort < distArr[nRow][nCol]) {
                        distArr[nRow][nCol] = newEffort;
                        PQ.add(new Pair(nRow, nCol, distArr[nRow][nCol]));
                    }
                }
            }
        }
        return 0;
    }
}
