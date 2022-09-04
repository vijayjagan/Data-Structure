package backtracking;

public class LeetCode_37 {

  boolean canWePlaceTheCharacter(int row, int column, char number, char[][] board) {
    // Vertical
    for (int i = 0; i < board.length; i++) {
      if (board[i][column] == number && i != row) {
        return false;
      }
    }

    // Horizontal
    for (int i = 0; i < board.length; i++) {
      if (board[row][i] == number && i != column) {
        return false;
      }
    }

    // 3 X 3
    int subRow = row % 3 == 0 ? row : row - (row % 3);
    int subCol = (column / 3) * 3;

    for (int i = subRow; i < subRow + 3; i++) {
      for (int j = subCol; j < subCol + 3; j++) {
        if (i != row && j != column && board[i][j] == number) {
          return false;
        }
      }
    }
    return true;
  }


  boolean solveSudokuViaBacktrack(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == '.') {
          for (char k = '1'; k <= '9'; k++) {
            if (canWePlaceTheCharacter(i, j, k, board)) {
              board[i][j] = k;
              if (solveSudokuViaBacktrack(board)) {
                return true;
              }
              board[i][j] = '.';
            }
          }
        }
        if (board[i][j] == '.') {
          return false;
        }
      }
    }
    return true;
  }

  public void solveSudoku(char[][] board) {
    solveSudokuViaBacktrack(board);
    for (char[] values : board) {
      for (char boardValue : values) {
        System.out.print(boardValue + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    new LeetCode_37().solveSudoku(board);
  }

}
