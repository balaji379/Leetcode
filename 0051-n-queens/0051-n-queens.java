class Solution {
    List<List<String>> out = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
         solve(new char[n][n],n,0);
         return out;
    }
    public void solve(char[][] mat, int n, int col) {
        if (n == 0) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < mat.length; i++){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < mat[i].length; j++){
                    if (mat[i][j] == 'Q')
                          sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            this.out.add(list);
        } else {
            for (int i = 0; i < mat.length; i++) {
                if (isSafe(mat, i, col)) {
                    mat[i][col] = 'Q';
                    solve(mat, n - 1, col + 1);
                    mat[i][col] = ' ';
                }
            }
        }
    }

    private boolean isSafe(char[][] mat, int row, int col) {
        int i = col;
        while (i >= 0) {
            if (mat[row][i] == 'Q')
                return false;
            i -= 1;
        }
        i = row;
        int j = col;
        while (row >= 0 && col >= 0) {
            if (mat[row][col] == 'Q')
                return false;
            row -= 1;
            col -= 1;
        }
        row = i;
        col = j;
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == 'Q')
                return false;
            row += 1;
            col -= 1;
        }
        return true;
    }
}