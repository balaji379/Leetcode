class NumMatrix {
  
     int[][] sumRegion;
    
    public NumMatrix(int[][] matrix) {
        sumRegion = new int[matrix.length][matrix[0].length];
      
        for( int i = 0; i < matrix.length; i++ ){
            int pre = 0;
            for( int j = 0; j < matrix[i].length; j++){
                sumRegion[i][j] = pre + matrix[i][j];
                pre = sumRegion[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
         
          int sum = 0;
          for( int i = row1; i <= row2; i++){
            do{
                sum += sumRegion[i][col2]  - ( col1 != 0 ? sumRegion[i][col1 - 1] : 0 ) ;
            }while(false);
          }

          return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */