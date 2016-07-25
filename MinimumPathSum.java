/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;//row size
        int m = grid[0].length;//column size
        int[][] f = new int[n][m];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) f[0][i] = f[0][i - 1] + grid[0][i];
        for (int i = 1; i < n; i++) f[i][0] = f[i - 1][0] + grid[i][0];
        if (n == 1) return f[0][m - 1];
        if (m == 1) return f[n - 1][0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                f[i][j] = min(f[i - 1][j], f[i][j - 1]) + grid[i][j];//dp
            }
        }
        return f[n - 1][m - 1];
    }
    public int min(int x, int y) {
        return x > y ? y : x;
    }
}