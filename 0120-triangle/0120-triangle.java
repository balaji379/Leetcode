class Solution {
    public int minimumTotal(List<List<Integer>> mat) {
        
         int[][] dp = new int[mat.size()][mat.get(mat.size() - 1).size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return (int)findMinPathSum(0,0,dp,mat);
    }

    public static long findMinPathSum(int r, int c, int[][] dp,  List<List<Integer>> mat) {
        if (r >= dp.length)
            return Integer.MAX_VALUE;
        if (r == mat.size() - 1 && c >= 0)
            return mat.get(r).get(c);
        if (dp[r][c] != Integer.MIN_VALUE)
            return dp[r][c];

        long downcol = findMinPathSum(r + 1, c, dp, mat);
        long downpluscol = findMinPathSum(r + 1, c + 1, dp, mat);
        if (downcol < downpluscol)
            dp[r][c] = mat.get(r).get(c) + (int) downcol;
        else
            dp[r][c] = mat.get(r).get(c) + (int) downpluscol;
        return dp[r][c];
    }
    
}