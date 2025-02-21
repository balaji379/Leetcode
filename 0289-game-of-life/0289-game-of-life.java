class Solution {
    public void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        // IntStream.range(0, board.length).forEach(i -> {
        //     IntStream.range(0, board[i].length).forEach(j -> ans[i][j] = board[i][j]);
        // });
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
                ans[i][j] = board[i][j];
        }
        gameOfLifes(board, ans);
    }

    public void gameOfLifes(int[][] board, int[][] ans) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int left = j - 1;
                int right = j + 1;
                int down = i + 1, up = i - 1;
                int total = 0;
                if (left >= 0) {
                    if (ans[i][left] == 1)
                        total += 1;
                }
                if (right < board[i].length) {
                    if (ans[i][right] == 1)
                        total += 1;
                }
                if (up >= 0) {
                    if (ans[up][j] == 1)
                        total += 1;
                    if (left >= 0) {
                        if (ans[up][left] == 1)
                            total += 1;
                    }
                    if (right < board[i].length) {
                        if (ans[up][right] == 1)
                            total += 1;
                    }
                }
                if (down >= 0 && down < board.length) {
                    if (board[down][j] == 1)
                        total += 1;
                    if (left >= 0) {
                        if (ans[down][left] == 1)
                            total += 1;
                    }
                    if (right < ans[i].length) {
                        if (ans[down][right] == 1)
                            total += 1;
                    }
                }
                if (board[i][j] == 1) {
                    if (total < 2)
                        board[i][j] = 0;
                    else if (total == 2 || total == 3)
                        board[i][j] = 1;
                    else if (total > 3)
                        board[i][j] = 0;
                } else {
                    if (total == 3)
                        board[i][j] = 1;
                }
            }
        }
    }
}
