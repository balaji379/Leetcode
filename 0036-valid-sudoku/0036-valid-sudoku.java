class Solution {
    public boolean isValidSudoku(char[][] board) {
     
      int len = board.length;
        int height = 0, width = 0;
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        int[][] block = new int[3][10];
        for (int i = 0; i < 10; i++)
            col.put(i, new HashSet<Character>());
        for (int i = 0; i < len; i++) {
            height = i / 3;
            int[] row = new int[10];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                width = j / 3;
                // row
                if (row[board[i][j] - '0'] == board[i][j])
                    return false;
                else
                    row[board[i][j] - '0'] = board[i][j];
                // col
                if (col.get(j).contains(board[i][j]))
                    return false;
                else
                    col.get(j).add(board[i][j]);
                // block
                if (block[width][board[i][j] - '0'] == ((height + width) + 1))
                    return false;
                else
                    block[width][board[i][j] - '0'] = (height + width) + 1;
            }
        }
        return true;
    }
}