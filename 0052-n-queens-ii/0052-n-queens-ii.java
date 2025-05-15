class Solution {
    int count;
    public int totalNQueens(int n) {
        solve(new char[n][n],0,n);
        return count;
    }
     public  void solve(char[][] mat,int col,int n){
        if (n == 0){
           count += 1;
            return;
        }
        for (int i = 0; i < mat.length; i++){
            if (isSafe(mat,i,col)){
                mat[i][col] = 'Q';
                solve(mat,col + 1,n - 1);
                mat[i][col] = ' ';
            }
        }
    }

    private  boolean isSafe(char[][] mat, int row, int col) {
        int temprow = row,tempcol = col;
//        left
        for(int i = col; i >=0; --i){
            if (mat[row][i] == 'Q')
                  return false;
        }
//        top digonal
        while (row >= 0 && col >= 0){
            if (mat[row][col] == 'Q')
                 return false;
            row -= 1;
            col -= 1;
        }
//        bottom digonal
        row = temprow;
        col = tempcol;
        while (row < mat.length && col >=0){
            if (mat[row][col] == 'Q')
                 return false;
            row += 1;
            col -= 1;
        }
        return true;
    }
}