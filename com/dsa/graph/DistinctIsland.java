package com.dsa.graph;

import java.util.*;

public class DistinctIsland {
    static class Pair {
        int row;
        int col;

        Pair(int _r, int _c) {
            this.row = _r;
            this.col = _c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Pair p) {
                return p.row == this.row && p.col == this.col;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        DistinctIsland distinctIsland = new DistinctIsland();
        var ans = distinctIsland.countDistinctIslands(M);
        System.out.println(ans);
    }

    // [N * M * log(set of length which is N * M)] {for loop and Set}+ (N * M * 4) {DFS}
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int r = grid.length;
        int c = grid[0].length;
        Set<List<Pair>> shape = new HashSet<>();
        boolean[][] visited = new boolean[r][c];
        // 4 direction move
        int[] delR = {-1, 0, +1, 0};
        int[] delC = {0, +1, 0, -1};

        // N * M
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // first & last row, first & last col
                if (!visited[i][j] && grid[i][j] == 1) {
                    List<Pair> shapeList = new ArrayList<>();
                    // Always carry base row & col to calculate shape
                    // N * M * 4
                    dfs(i, j, grid, visited, shapeList, delR, delC, i, j);
                    shape.add(shapeList);
                }
            }
        }

        return shape.size();

    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited, List<Pair> shapeList,
                     int[] delR, int[] delC, int baseRow, int baseCol) {
        visited[row][col] = true;
        // maintain the shape
        shapeList.add(new Pair((row - baseRow), (col - baseCol)));

        for (int i = 0; i < 4; i++) {
            int nRow = row + delR[i];
            int nCol = col + delC[i];
            // boundary check
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
                    !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, visited, shapeList, delR, delC, baseRow, baseCol);
            }
        }
    }
}
