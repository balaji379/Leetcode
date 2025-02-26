class Solution {
    public int diagonalSum(int[][] mat) {
        int row = 0 , colp = 0, cols = mat[0].length - 1,sum = 0;
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
               if (colp == j && cols == j)
                   sum += mat[i][colp];
               else if (colp == j)
                  sum += mat[i][colp];
               else if (cols == j)
                  sum += mat[i][cols];
            }
            colp += 1;
            cols -= 1;
        }
        return sum;
    }
}