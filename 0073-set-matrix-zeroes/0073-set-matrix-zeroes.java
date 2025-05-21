class Solution {
    public void setZeroes(int[][] matrix) {
            boolean[] row = new boolean[matrix.length];
            boolean[] col = new boolean[matrix[0].length];
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[i].length; j++){
                    if (matrix[i][j] == 0){
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }
            for (int i = 0; i < row.length; i++){
                if (row[i])
                   setRowZero(matrix,i);
            }
            for (int i = 0; i < col.length; i++){
                if (col[i])
                  setColZero(matrix,i);
            }
    }
    public void setRowZero(int[][] mat,int row){
        for (int i = 0; i < mat[row].length; ++i){
            mat[row][i] = 0;
        }
    }
    public void setColZero(int[][] mat,int col){
        for (int i = 0; i < mat.length; ++i){
            mat[i][col] = 0;
        }
    }
}