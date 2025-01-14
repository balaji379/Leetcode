class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
         for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return countNoOfUnqiceWays(m - 1,n - 1,dp);
    }
     public int countNoOfUnqiceWays(int r, int c, int[][] dp) {
         if (r == 0 && c == 0)
            return 1;
        if (r < 0 || c < 0)
            return 0;
        if (dp[r][c] != -1)
            return dp[r][c];
        int left = countNoOfUnqiceWays(r - 1, c, dp);
        int right = countNoOfUnqiceWays(r, c - 1, dp);
        dp[r][c] = left + right;
        return left + right;
    }
}