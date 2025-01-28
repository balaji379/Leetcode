class Solution {
    public int findMaxFish(int[][] grid) {
        
 int max = 0;
 boolean[][] path = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0)
                    max = Math.max(catchMaxFish(grid, 0, i, j, path), max);
            }
        }
        return max;
    }

    public static int catchMaxFish(int[][] grid, int sum, int r, int c, boolean[][] path) {
        if (r >= grid.length || c >= grid[0].length || c < 0 || r < 0) {
            return sum;
        }
        if (grid[r][c] == 0)
             return sum;

        if (path[r][c])
            return sum;
        sum += grid[r][c];
        path[r][c] = true;
//        down
        sum = catchMaxFish(grid, sum, r + 1, c, path);
//       right
        sum = catchMaxFish(grid, sum, r, c + 1, path);
//       up
        sum = catchMaxFish(grid, sum, r - 1, c, path);
//       left
        sum = catchMaxFish(grid, sum, r, c - 1, path);

        // path[r][c] = false;
        return sum;
    }
}