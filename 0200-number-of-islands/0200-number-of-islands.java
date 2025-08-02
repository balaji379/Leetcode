class Pair {
    int first;
    int second;

    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, visited, grid, m, n);
                }
            }
        }
        return ans;
    }

    public void bfs(int ro, int co, int[][] vis, char[][] grid, int m, int n) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co));
        vis[ro][co] = 1;
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();
            int row = r + 1;
            int col = c;
            if (row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == 0 && grid[row][col] == '1') {
                vis[row][col] = 1;
                q.add(new Pair(row, col));
            }
            row = r - 1;
            col = c;
            if (row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == 0 && grid[row][col] == '1') {
                vis[row][col] = 1;
                q.add(new Pair(row, col));
            }
            row = r;
            col = c + 1;
            if (row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == 0 && grid[row][col] == '1') {
                vis[row][col] = 1;
                q.add(new Pair(row, col));
            }
            row = r;
            col = c - 1;
            if (row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == 0 && grid[row][col] == '1') {
                vis[row][col] = 1;
                q.add(new Pair(row, col));
            }
        }
    }
}