class Solution {
      public static void set0row(int[][] mat, int row) {
        for (int col = 0; col < mat[row].length; col++) {
            mat[row][col] = 0;
        }
    }

    public static void set0col(int[][] mat, int col) {
        for (int row = 0; row < mat.length; row++) {
            mat[row][col] = 0;
        }
    }
    public void setZeroes(int[][] mat) {
        int[] row = new int[mat.length];
        var max = -1;
        for (int[] arr : mat)
            max = Math.max(max, arr.length);
        int[] col = new int[max];
        int r = 0, c = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                set0row(mat, i);
            }
        }
        for (int i = 0; i < col.length; i++) {
            if (col[i] == 1)
                set0col(mat, i);
        }
    }
}