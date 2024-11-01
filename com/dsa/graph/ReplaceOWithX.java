package com.dsa.graph;

import java.util.Arrays;

public class ReplaceOWithX {
    public static void main(String[] args) {
        char[][] mat = {
                {'X', 'X', 'X', 'X' },
                {'X', 'O', 'X', 'X' },
                {'X', 'O', 'O', 'X' },
                {'X', 'O', 'X', 'X' },
                {'X', 'X', 'O', 'O' }};
        var ans = fill(mat.length, mat[0].length, mat);
        System.out.println(Arrays.deepToString(ans));
    }

    // TC: O(N) + O(N*M). ~ O(M*N), SC: O(M*N)
    static char[][] fill(int n, int m, char a[][]) {
        // code here
        char[][] filledMatrix = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        // visit first row & last row to find any O's
        for (int j = 0; j < m; j++) {
            // first row
            if (a[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, a, visited, delRow, delCol);
            }
            // last row
            if (a[n - 1][j] == 'O' && !visited[n - 1][j]) {
                dfs(n - 1, j, a, visited, delRow, delCol);
            }
        }

        // first & last column
        for (int i = 0; i < n; i++) {
            // first column
            if (a[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, a, visited, delRow, delCol);
            }
            // last column
            if (a[i][m - 1] == 'O' && !visited[i][m - 1]) {
                dfs(i, m - 1, a, visited, delRow, delCol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && a[i][j] == 'O') {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }

    private static void dfs(
            int sr, int sc, char[][] matrix, boolean[][] visited,
            int[] delRow, int[] delCol) {
        visited[sr][sc] = true;
        int row = matrix.length;
        int col = matrix[0].length;


        for (int i = 0; i < 4; i++) {
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];

            // boundary check
            if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col &&
                    !visited[nRow][nCol] && matrix[nRow][nCol] == 'O') {
                dfs(nRow, nCol, matrix, visited, delRow, delCol);
            }
        }
    }
}
