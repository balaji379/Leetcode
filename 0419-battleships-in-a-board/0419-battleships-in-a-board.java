// class Pair {
//     int first;
//     int second;

//     public Pair(int f, int s) {
//         this.first = f;
//         this.second = s;
//     }
// }

class Solution {
    public int countBattleships(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i-1 >= 0 && j-1 >= 0 && grid[i][j] == 'X' && grid[i-1][j] != 'X' && grid[i][j-1] != 'X')
                    ans++;
                else if(i-1 == -1 && j-1 == -1 && grid[i][j] == 'X') 
                    ans++;
                else if(i-1 == -1 && grid[i][j] == 'X' && grid[i][j-1] != 'X')
                    ans++;
                else if(j-1 == -1 && grid[i][j] == 'X' && grid[i-1][j] != 'X')
                    ans++;
            }
        }
        return ans;
    }

    // public void bfs(int ro, int co, int[][] vis, char[][] grid, int m, int n){
    //     Queue<Pair> q = new LinkedList<Pair>();
    //     q.add(new Pair(ro,co));
    //     vis[ro][co] = 1;
    //     while(!q.isEmpty()){
    //         int r = q.peek().first;
    //         int c = q.peek().second;
    //         q.poll();
    //         if(row >= 0 && row < m && col >= 0 && col < n && (vis[r-1][c] == 1 && grid[r-1][c] == 'X') || (vis[r][c-1] == 1)){

    //         }
    //     }
    // }
}