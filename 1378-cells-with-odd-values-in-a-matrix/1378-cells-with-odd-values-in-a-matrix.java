class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][]  mat = new int[m][n];
        for (int[] ind : indices){
             incrow(mat,ind[0]);
             inccol(mat,ind[1]);
        }
        int sum = 0;
        for (int[] arr : mat){
              for (int val : arr){
                if (val % 2 != 0)
                     sum += 1;
              }
        }
        
        return sum;
    }
        public void incrow(int[][] mat,int row){
            for (int i = 0; i < mat[row].length; i++)
                mat[row][i] += 1;
        }
        public void inccol(int[][] mat,int col){
            for (int i = 0; i < mat.length; i++){
                mat[i][col] += 1;
            }
    }

}