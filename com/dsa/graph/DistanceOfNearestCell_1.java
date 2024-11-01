package com.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=edXdVwkYHF8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14

/**
 * 1. Use BFS Algo
 * 2. initial config is: Queue(row, col, current distance), visited array,
 * result array which has each cell's distance,4 direction config
 * 3. initially, store all the cell which has 1, and it's distance as 0.
 * 4. Traverse the queue until it's empty.
 *      4.1. Remove current pair from queue.
 *      4.2. check all the 4 direction if is there any unvisited and 0 cell available.
 *      4.3. if yes, put into queue by increasing the distance and mark it as visited.
 */
public class DistanceOfNearestCell_1 {
    static class Pair {
        int row;
        int col;
        int distance;

        Pair(int _r, int _c, int _d) {
            this.row = _r;
            this.col = _c;
            this.distance = _d;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        DistanceOfNearestCell_1 distance = new DistanceOfNearestCell_1();
        var ans = distance.nearest(grid);
        System.out.println(Arrays.deepToString(ans));
    }
    // TC: O(row*col), SC: O(row * col)
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        // answer store
        int[][] distance = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        Queue<Pair> queue = new LinkedList<>();
        // 4 direction config
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        // add initial data into queue and mark them visited
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // n * m
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currRow = pair.row;
            int currCol = pair.col;
            int currDistance = pair.distance;
            // store the distance for current node
            distance[currRow][currCol] = currDistance;
            // move 4 direction
            // n * m * 4
            for (int i = 0; i < 4; i++) {
                // get neighbour row & column
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];
                // check boundary and for every 0 put into queue by increasing the step
                if (nRow >= 0 && nRow < r && nCol >= 0 && nCol < c && !visited[nRow][nCol]
                        && grid[nRow][nCol] == 0) {
                    queue.add(new Pair(nRow, nCol, currDistance + 1));
                    visited[nRow][nCol] = true;
                }
            }
        }

        return distance;
    }
}
