class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        return first_Completely_Painted_RoworColumn(mat,arr);
    }
    public int first_Completely_Painted_RoworColumn(int[][] mat, int...nums) {
        Map<Integer,int[]> indexMap = new HashMap<>();
        Map<Integer,Integer> row = new HashMap<>();
        Map<Integer,Integer> col = new HashMap<>();
        int r = mat[0].length,c = mat.length;
        boolean flag = true;
        for (int i = 0; i < mat.length; i++) {
            row.put(i,0);
            for (int j = 0; j < mat[0].length; j++) {
                if (flag)
                    col.put(j,0);
                 indexMap.put(mat[i][j],new int[]{i,j});
            }
        }
        for (int i = 0; i < nums.length; i++){
            int[] index = indexMap.get(nums[i]);
            row.put(index[0], row.get(index[0]) + 1);
            col.put(index[1],col.get(index[1]) + 1);
            if (row.get(index[0]) == r)
                 return i;
            if (col.get(index[1]) == c)
                return i;
        }
        return -1;
    }
}