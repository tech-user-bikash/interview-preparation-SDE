package com.dsa.graph;

import java.util.Arrays;

public class FloodFillAlgo {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFillAlgo algo = new FloodFillAlgo();
        int[][] ans = algo.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(ans));
    }

    // TC: O(Row * Col)
    // SC: O(Row * Col)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int[][] ans = image;
        int initialColor = image[sr][sc];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        dfs(image, sr, sc, initialColor, newColor, ans, delRow, delCol);
        return ans;
    }

    private void dfs(int[][] image, int sr, int sc, int initialColor, int newColor,
                     int[][] ans, int[] delRow, int[] delCol) {
        ans[sr][sc] = newColor;
        int row = image.length;
        int col = image[0].length;
        // visit all 4 direction
        for (int i = 0; i < 4; i++) {
            int newRow = sr + delRow[i];
            int newCol = sc + delCol[i];
            // check boundary for new row & col
            if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col
                    && image[newRow][newCol] == initialColor && ans[newRow][newCol] != newColor) {
                dfs(image, newRow, newCol, initialColor, newColor, ans, delRow, delCol);
            }
        }
    }
}
