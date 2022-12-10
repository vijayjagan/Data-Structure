package backtracking;

public class LeetCode_79 {

  static boolean isExist(int r, int c, int index, char[][] board, char[] word) {
    if (word.length == index) {
      return true;
    }
    if (r > -1 && c > -1 && r < board.length && c < board[0].length && board[r][c] != '-') {
      if (word[index] == board[r][c]) {
        board[r][c] = '-';
        boolean left = isExist(r, c - 1, index + 1, board, word);
        boolean right = isExist(r, c + 1, index + 1, board, word);
        boolean up = isExist(r - 1, c, index + 1, board, word);
        boolean down = isExist(r + 1, c, index + 1, board, word);
        board[r][c] = word[index];
        return left || right || up || down;
      }
    }
    return false;
  }


  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (word.charAt(0) == board[i][j] && isExist(i, j, 0, board, word.toCharArray())) {
          return true;
        }
      }
    }
    return false;
  }

}
