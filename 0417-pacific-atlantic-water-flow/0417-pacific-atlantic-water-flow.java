class Solution {
    private  int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        List<List<Integer>> coordinates = new ArrayList<>();
        
        boolean[][] pacific = new boolean[mat.length][mat[0].length];
        boolean[][] atlantic = new boolean[mat.length][mat[0].length];

        // For columns
        for (int i = 0; i < mat[0].length; i++) {
            solve(mat, 0, i, Integer.MIN_VALUE, pacific);
            solve(mat, mat.length - 1, i, Integer.MIN_VALUE, atlantic);
        }

        // For rows
        for (int i = 0; i < mat.length; i++) {
            solve(mat, i, 0, Integer.MIN_VALUE, pacific);
            solve(mat, i, mat[0].length - 1, Integer.MIN_VALUE, atlantic);
        }

        // Preparing intersection part
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    coordinates.add(List.of(i, j));
                }
            }
        }
        
        return coordinates;
    }

    public  void solve(int[][] mat, int i, int j, int pre, boolean[][] ocean) {
        if (i >= mat.length || i < 0 || j >= mat[i].length || j < 0) return;

        if (mat[i][j] < pre || ocean[i][j]) return;

        ocean[i][j] = true;
        for (int[] d : dir) {
            solve(mat, i + d[0], j + d[1], mat[i][j], ocean);
        }
    }
}