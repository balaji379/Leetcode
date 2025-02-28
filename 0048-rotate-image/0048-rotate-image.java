class Solution {
    public void rotate(int[][] mat) {
        //        transpose
             for (int i = 0; i < mat.length; i++){
                 for (int j = i; j < mat[i].length;j++){
                     if (i != j){
                         int temp = mat[i][j];
                         mat[i][j] = mat[j][i];
                         mat[j][i] = temp;
                     }
                 }
             }
//             reverse
             for (int[] m : mat){
                 for (int i = 0,j = m.length -1; i <= j ; i++,j--) {
                     int temp = m[i];
                     m[i] = m[j];
                     m[j] = temp;
                 }
             }
    }
}