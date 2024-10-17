package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCount {

    static class Pair {
        int row;
        int col;
        Pair(int r , int c){
            this.row = r;
            this.col = c;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1}, {1,0}, {1,1}, {1,0}};
        var res = numIslands(grid);
        System.out.println(res);
    }
    public static int numIslands(int[][] grid) {
        // Code here
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int cnt = 0;


        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    // dfs(grid, visited, i, j);
                    bfs(grid, visited, i, j);
                }
            }
        }
        return cnt;
    }

    private static void bfs(int[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();

            // traverse all 8 direction neighbour's until find a land
            for(int delRow = -1; delRow<=1; delRow++){
                for(int delCol = -1; delCol <=1; delCol++){
                    int neighbourRow = pair.row + delRow;
                    int neighbourCol = pair.col + delCol;
                    // check boundary condition
                    if(neighbourRow >=0 && neighbourRow < grid.length && neighbourCol >= 0 && neighbourCol < grid[0].length
                            && grid[neighbourRow][neighbourCol] == 1 && !visited[neighbourRow][neighbourCol]){
                        queue.add(new Pair(neighbourRow,neighbourCol));
                        visited[neighbourRow][neighbourCol] = true;
                    }
                }
            }

        }
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;

        // top, land, visited check
        if(row-1 >=0 && grid[row-1][col] == 1 && !visited[row-1][col]){
            visited[row-1][col] = true;
            dfs(grid, visited, row-1, col);
        }

        // bottom, land, visited check
        if(row+1 <= grid.length-1 && grid[row+1][col] == 1 && !visited[row+1][col]){
            visited[row+1][col] = true;
            dfs(grid, visited, row+1, col);
        }

        // left, land, visited check
        if(col-1 >=0 && grid[row][col-1] == 1 && !visited[row][col-1]){
            visited[row][col-1] = true;
            dfs(grid, visited, row, col-1);
        }

        // right, land, visited check
        if(col+1 <= grid[row].length-1 && grid[row][col+1] == 1 && !visited[row][col+1]){
            visited[row][col+1] = true;
            dfs(grid, visited, row, col+1);
        }

        // top-right, land, visited check
        if(row-1 >=0 && col+1<=grid[row-1].length-1 && grid[row-1][col+1] == 1 && !visited[row-1][col+1]){
            visited[row-1][col+1] = true;
            dfs(grid, visited, row-1, col+1);
        }

        // bottom-right, land, visited check
        if(row+1 <= grid.length-1 && col+1<=grid[row+1].length-1 && grid[row+1][col+1] == 1 && !visited[row+1][col+1]){
            visited[row+1][col+1] = true;
            dfs(grid, visited, row+1, col+1);
        }

        // left-top, land, visited check
        if(col-1 >=0 && row-1 >=0 && grid[row-1][col-1] == 1 && !visited[row-1][col-1]){
            visited[row-1][col-1] = true;
            dfs(grid, visited, row-1, col-1);
        }

        // left-bottom, land, visited check
        if(col-1 >= 0 && row+1 <= grid.length-1 && grid[row+1][col-1] == 1 && !visited[row+1][col-1]){
            visited[row+1][col-1] = true;
            dfs(grid, visited, row+1, col-1);
        }
    }
}
