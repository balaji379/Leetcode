class Solution {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        boolean answer = false;
        boolean visited[][] = new boolean[board.length][board[0].length];
        OUTERLOOP:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer = exist(i, j, 0, visited, board, letters, answer);
                if (answer)
                    break OUTERLOOP;
            }
        }
     return answer;
    }

    public static boolean exist(int r, int c, int index, boolean[][] visited, char[][] board, char[] letters, boolean answer) {
        if (letters.length - index == 0)
            return true;

        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || answer) {
            return answer;
        }

        if (visited[r][c] || board[r][c] != letters[index])
            return answer;

        visited[r][c] = true;
        index += 1;

        answer = !answer ? exist(r + 1, c, index, visited, board, letters, answer) : true;
        answer = !answer ? exist(r, c + 1, index, visited, board, letters, answer) : true;
        answer = !answer ? exist(r - 1, c, index, visited, board, letters, answer) : true;
        answer = !answer ? exist(r, c - 1, index, visited, board, letters, answer) : true;
        visited[r][c] = false;
        return answer;
    }  
}