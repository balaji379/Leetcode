class Solution {
    int ans = 0;
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] > 0) {
                    int count = dfs(i, j, vis, grid, m, n);
                    ans = Math.max(ans,count);
                }
            }
        }
        return ans;
    }

    public int dfs(int ro,int co,int[][] vis,int[][] grid,int m, int n){
        if(ro < 0 || co < 0 || ro >= m || co >= n) return 0;

        if(vis[ro][co] == 0 && grid[ro][co] > 0){
            vis[ro][co] = 1;
            int count = grid[ro][co];
            count += dfs(ro,co+1,vis,grid,m,n);
            count += dfs(ro,co-1,vis,grid,m,n);
            count += dfs(ro+1,co,vis,grid,m,n);
            count += dfs(ro-1,co,vis,grid,m,n);
            return count;
        }
        return 0;
    }
}