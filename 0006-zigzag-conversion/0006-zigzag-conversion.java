class Solution {
    public static int row(char[][] mat, String str, int j, int[] arrinfo) {
        int len = mat.length;
        int strlen = str.length();
        for (int i = 0; i < len && arrinfo[1] < strlen; i++, arrinfo[1]++) {
            mat[i][j] = str.charAt(arrinfo[1]);
        }
        return j;
    }
    public  String convert(String str, int row) {
        int j = 0;
        char[][] mat = new char[row][2000];
        int[] arrinfo = new int[] { 0, 0 };
        for (int i = 0; i < str.length(); i++) {
            Solution.row(mat, str, j, arrinfo);
            j = Solution.rowandcol(mat, str, row - 2, j + 1, arrinfo);
        }
        String output = "";
        for (char[] m : mat) {
            for (int i = 0; i < j; i++) {
                if (Character.isAlphabetic(m[i]) || m[i]==',' ||m[i]=='.'){
                    output += String.valueOf(m[i]);
                }
            }
        }
        return output;
    }
    public static int rowandcol(char[][] mat, String str, int i, int j, int[] arrinfo) {
        int strlen = str.length();
        for (i = i; i >= 1 && arrinfo[1] < strlen; i--, arrinfo[1]++, j++) {
            mat[i][j] = str.charAt(arrinfo[1]);
        }

        return j;
    }
    
}