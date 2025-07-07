class Solution {
    int row = 0, col = 0;
    Set<String> set = new HashSet<>();
    int[] ans;
    public int[] findDiagonalOrder(int[][] mat) {
        ans = new int[mat[0].length * mat.length];
        dt(mat);
        return ans;
    }

    public void dt(int[][] mat) {
        int visited_cells = 0, total_cell = mat.length * mat[0].length;

        List<Integer> list = new ArrayList<>();
        while (visited_cells < total_cell) {
            while (row >= 0 && col < mat[0].length) {
                set.add(String.valueOf(row) + String.valueOf((col)));
                ans[visited_cells] = mat[row][col];
                visited_cells += 1;
                row -= 1;
                col += 1;
            }
            if (!(visited_cells < total_cell))
                break;
            fixRowAndCol(mat[0].length, mat.length);

            while (row < mat.length && col >= 0) {
                set.add(String.valueOf(row) + String.valueOf((col)));
                ans[visited_cells] = mat[row][col];
                visited_cells += 1;
                row += 1;
                col -= 1;
            }
            fixRowAndCol(mat[0].length, mat.length);
        }
    }

    private void fixRowAndCol(int clen, int rlen) {
        if (row < 0 || col >= clen) {
            if (row < 0)
                row = 0;
            if (col >= clen)
                col = clen - 1;
            String key = String.valueOf(row) + String.valueOf(col);
            while (set.contains(key)) {
                row += 1;
                key = String.valueOf(row) + String.valueOf(col);
            }
        } else if (row >= rlen || col < 0) {
            if (row >= rlen)
                row = rlen - 1;
            if (col < 0)
                col = 0;
            String key = String.valueOf(row) + String.valueOf(col);
            while (set.contains(key)) {
                col += 1;
                key = String.valueOf(row) + String.valueOf(col);
            }
        }
    }
}