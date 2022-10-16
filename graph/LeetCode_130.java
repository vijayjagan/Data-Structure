package graph;

public class LeetCode_130 {


  void markBoundaryConnectedData(int row, int column, int rLength, int cLength, char[][] board) {
    if (row < 0 || column < 0 || row >= rLength || column >= cLength || board[row][column] != 'O') {
      return;
    }
    board[row][column] = '-';
    markBoundaryConnectedData(row + 1, column, rLength, cLength, board);
    markBoundaryConnectedData(row - 1, column, rLength, cLength, board);
    markBoundaryConnectedData(row, column + 1, rLength, cLength, board);
    markBoundaryConnectedData(row, column - 1, rLength, cLength, board);
  }


  public void solve(char[][] board) {
    int rowLength = board.length;
    int colLength = board[0].length;

    // Upper and lower Boundaries
    for (int i = 0; i < colLength; i++) {
      if (board[0][i] == 'O') {
        markBoundaryConnectedData(0, i, rowLength, colLength, board);
      }
      if (board[rowLength - 1][i] == 'O') {
        markBoundaryConnectedData(rowLength - 1, i, rowLength, colLength, board);
      }
    }

    for (int i = 0; i < rowLength; i++) {
      if (board[i][0] == 'O') {
        markBoundaryConnectedData(i, 0, rowLength, colLength, board);
      }
      if (board[i][colLength - 1] == 'O') {
        markBoundaryConnectedData(i, colLength - 1, rowLength, colLength, board);
      }
    }

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        if (board[i][j] == '-') {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }

}
