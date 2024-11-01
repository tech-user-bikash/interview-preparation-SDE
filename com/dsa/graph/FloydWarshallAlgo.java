package com.dsa.graph;

import java.util.Arrays;

public class FloydWarshallAlgo {

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 43},{1, 0, 6}, {-1, -1, 0}};
        shortestDistance(mat);
        System.out.println(Arrays.deepToString(mat));
    }
    // TC: N^3, SC: = N^2
    public static void shortestDistance(int[][] mat) {
        int n = mat.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == -1){
                    mat[i][j] = (int)1e9;
                }
                // place diagonal value as 0
                if(i == j){
                    mat[i][j] = 0;
                }
            }
        }

        // TC: O(N X N X N)
        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][via]+mat[via][j]);
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1e9){
                    mat[i][j] = -1;
                }
            }
        }
    }
}
