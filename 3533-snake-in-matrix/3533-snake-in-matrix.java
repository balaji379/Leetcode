class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
          int[][] mat= new int[n][n];
          int val = 0;
          for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = val++;
            }
          }
          int i = 0 , j = 0;
          for (String command : commands){
            if (command.equals("DOWN"))
                   i += 1;
            else if (command.equals("RIGHT"))
                j += 1;
            else if (command.equals("LEFT"))
                 j -= 1;
            else if (command.equals("UP"))
                 i -= 1;
          }
          return mat[i][j];
    }
}