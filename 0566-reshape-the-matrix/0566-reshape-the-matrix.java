class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
          List<Integer> list = new ArrayList<>();
          for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                list.add(mat[i][j]);
            }
          }
          int[][] newmat = new int[r][c];
          if (list.size() != r * c){
            return mat;
          }
          int index = 0;
          for (int i = 0; i < newmat.length; i++){
            for (int j = 0; j < newmat[i].length; j++){
                newmat[i][j] = list.get(index++);
            }
          }
          return newmat;
    }
}