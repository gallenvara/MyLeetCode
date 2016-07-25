/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        if (n == 1) return 1;
        if (m == 1) return 1;
        for (int i = 1; i < m; i++) f[i][0] = 1;
        for (int i = 1; i < n; i++) f[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1]; //dp
            }
        }
        return f[m - 1][n - 1];
    }
}
   