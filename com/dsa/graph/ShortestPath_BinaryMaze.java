package com.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath_BinaryMaze {
    static class Pair {
        int row;
        int col;
        int dist;

        Pair(int _r, int _c, int _d) {
            this.row = _r;
            this.col = _c;
            this.dist = _d;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int[] source = {0, 1};
        int[] destination = {2, 2};
        ShortestPath_BinaryMaze binaryMaze = new ShortestPath_BinaryMaze();
        var ans = binaryMaze.shortestPath(grid,source,destination);
        System.out.println(ans);
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int r = grid.length;
        int c = grid[0].length;

        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        int[][] distArr = new int[r][c];
        for (int[] A : distArr) {
            Arrays.fill(A, (int) 1e9);
        }
        distArr[source[0]][source[1]] = 0;

        return dijkstra(source[0], source[1], grid, distArr, destination);

    }

    private int dijkstra(int row, int col, int[][] grid, int[][] distArr, int[] destination) {
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(row, col, 0));

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        while (!Q.isEmpty()) {
            Pair p = Q.poll();
            // visit 4 directions
            for (int i = 0; i < 4; i++) {
                int nRow = p.row + delRow[i];
                int nCol = p.col + delCol[i];

                // check boundaries of new row & col
                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length
                        && grid[nRow][nCol] == 1 && (p.dist + 1) < distArr[nRow][nCol]) {
                    if (destination[0] == nRow && destination[1] == nCol) {
                        return p.dist + 1;
                    }
                    distArr[nRow][nCol] = p.dist + 1;
                    Q.add(new Pair(nRow, nCol, distArr[nRow][nCol]));
                }
            }
        }
        return -1;
    }
}
