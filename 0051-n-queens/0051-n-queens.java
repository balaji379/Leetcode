class Solution {
    List<List<String>> outer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
         solve(new char[n][n],0,n);
         return outer;
    }
     public  void solve(char[][] mat,int col,int n){
        if (n == 0){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < mat.length; ++i){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < mat[i].length; ++j){
                    if (mat[i][j] == 'Q')
                         sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            outer.add(list);
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