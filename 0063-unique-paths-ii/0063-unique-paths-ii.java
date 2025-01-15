class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
             return 0;
        int[][] dp = new int[m][n];
         for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return findUniquePath(m - 1,n - 1, dp, obstacleGrid);
    }
     public  int findUniquePath(int r, int c, int[][] dp, int[][] mat) {
        if (r < 0 || c < 0)
            return 0;
        if (r == 0 && c == 0)
            return 1;
        if (mat[r][c] == 1)
            return 0;
        if (dp[r][c] != -1)
            return dp[r][c];

        int up = findUniquePath(r - 1, c, dp, mat);
        int left = findUniquePath(r, c - 1, dp, mat);
        dp[r][c] = up + left;
        return up + left;
    }
}