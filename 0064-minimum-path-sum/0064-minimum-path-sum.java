class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int m = dp.length - 1,n = dp[0].length - 1;
        return (int)findMininumPathSum(m, n, dp, grid);
    }
    public  long findMininumPathSum(int r, int c, int[][] dp, int[][] mat) {
        if (r < 0 || c < 0)
            return Integer.MAX_VALUE;
        if (r == 0 && c == 0)
            return mat[r][c];
        if (dp[r][c] != -1)
            return dp[r][c];

        long up = findMininumPathSum(r - 1, c, dp, mat);
        long upPathSum = up + mat[r][c];
        long left = findMininumPathSum(r, c - 1, dp, mat);
        long leftPathSum = left + mat[r][c];
        if (upPathSum < leftPathSum)
            dp[r][c] = (int) upPathSum;
        else
            dp[r][c] = (int) leftPathSum;
        return dp[r][c];
    }
}