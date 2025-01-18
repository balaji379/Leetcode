class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int minPathsum = Integer.MAX_VALUE;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        if (matrix.length > 1){
             for (int i = 0; i < dp[0].length; i++)
                    findFallingPathSum(0, i, dp, matrix);
        
             for (int i = 0; i < dp[0].length; i++)
                      minPathsum = Math.min(minPathsum,dp[0][i]);
        }
        else{
             for (int i = 0; i < matrix[0].length; i++)
                      minPathsum = Math.min(minPathsum,matrix[0][i]);
        }
        return minPathsum;
    }

    public static int findFallingPathSum(int r, int c, int[][] dp, int[][] mat) {
        if (r == dp.length || c < 0 || c >= dp[0].length)
            return Integer.MAX_VALUE;

        if (r == dp.length - 1 && c >= 0 && c < dp[0].length)
            return mat[r][c];

        if (dp[r][c] != Integer.MAX_VALUE)
            return dp[r][c];

        long down = findFallingPathSum(r + 1, c, dp, mat);

        long leftd = findFallingPathSum(r + 1, c - 1, dp, mat);

        long rightd = findFallingPathSum(r + 1, c + 1, dp, mat);

        long min = Math.min(down, leftd);
        min = Math.min(min, rightd);
        dp[r][c] = mat[r][c] + (int) min;
        return dp[r][c];
    }
}