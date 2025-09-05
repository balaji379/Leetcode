class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                max = Math.max(max,solve(grid,i,j));
            }
        }
        return max;
    }

    public int solve(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) return 0;
        int ans = grid[x][y];
        grid[x][y] = 0;
        int val = 0;
        val = Math.max(val,solve(grid,x-1,y));
        val = Math.max(val,solve(grid,x+1,y));
        val = Math.max(val,solve(grid,x,y-1));
        val = Math.max(val,solve(grid,x,y+1));
        grid[x][y] = ans;
        return ans + val;
    }
}