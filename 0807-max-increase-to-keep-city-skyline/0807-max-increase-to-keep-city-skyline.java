class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i = 0; i < m; i++){
            int max = 0;
            for(int j = 0; j < n; j++){
                max = Math.max(max,grid[i][j]);
            }
            rows[i] = max;
        }
        
        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = 0; j < m; j++){
                max = Math.max(max,grid[j][i]);
            }
            cols[i] = max;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int max = Math.min(rows[i],cols[j]);
                ans += Math.abs(grid[i][j] - max);
            }
        }
        return ans;
    }
}