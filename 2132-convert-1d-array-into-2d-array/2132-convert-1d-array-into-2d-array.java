class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
          int size = m * n;
          if (size != original.length)
                  return new int[0][0];
          int index = 0;
          int[][] mat = new int[m][n];
          for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = original[index++];
            }
          }
          return mat;
    }
}