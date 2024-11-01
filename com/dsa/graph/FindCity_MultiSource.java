package com.dsa.graph;

// https://www.geeksforgeeks.org/problems/city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
// https://www.youtube.com/watch?v=PwMVNSJ5SLI&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=43
public class FindCity_MultiSource {
    public static void main(String[] args) {
        int n = 4, m = 4, distanceThreshold = 4;
        int[][] edges = {{0, 1, 3},
        {1, 2, 1},
        {1, 3, 4},
        {2, 3, 1}};
        var ans = findCity(n,m,edges,distanceThreshold);
        System.out.println(ans);
    }
    static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < m; i++) {
            mat[edges[i][0]][edges[i][1]] = edges[i][2];
            mat[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for (int k = 0; k < n; k++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (u == v) continue;
                    if (mat[u][k] == 0 || mat[k][v] == 0) continue;
                    if (mat[u][v] == 0) {
                        mat[u][v] = mat[u][k] + mat[k][v];
                    } else{
                        mat[u][v] = Math.min(mat[u][v], mat[u][k] + mat[k][v]);
                    }
                }
            }
        }

        int city = 0;
        int cityCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (mat[i][j] != 0 && mat[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= cityCount) {
                cityCount = count;
                city = i;
            }
        }
        return city;
    }
}
