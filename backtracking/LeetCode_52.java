package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_52 {

  boolean canWePlaceTheQueen(int row, int column, int boardSize, char[][] board) {
    // Vertical
    for (int i = 0; i < boardSize; i++) {
      if (board[i][column] == 'Q' && i != row) {
        return false;
      }
    }

    // Horizontal
    for (int i = 0; i < boardSize; i++) {
      if (board[row][i] == 'Q' && i != row) {
        return false;
      }
    }

    // Left Diagonal
    int lRow = 0, lColumn = 0;
    for (int i = row, j = column; i > -1 && j > -1; i--, j--) {
      lRow = i;
      lColumn = j;
    }

    for (int i = lRow, j = lColumn; i < boardSize && j < boardSize; i++, j++) {
      if (i != row && j != column && board[i][j] == 'Q') {
        return false;
      }
    }

    // Right Diagonal
    int rRow = 0, rColumn = 0;
    for (int i = row, j = column; i > -1 && j < boardSize; i--, j++) {
      rRow = i;
      rColumn = j;
    }

    for (int i = rRow, j = rColumn; i < boardSize && j > -1; i++, j--) {
      if (i != row && j != column && board[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }


  int fillTheQueen(int row, int boardSize, char[][] board) {
    int count = 0;

    if (row == boardSize) {
      return count + 1;
    }

    for (int i = 0; i < boardSize; i++) {
      if (canWePlaceTheQueen(row, i, boardSize, board)) {
        board[row][i] = 'Q';
        count += fillTheQueen(row + 1, boardSize, board);
        board[row][i] = '.';
      }
    }
    return count;
  }


  public int totalNQueens(int n) {
    char[][] board = new char[n][n];
    for (char[] value : board) {
      Arrays.fill(value, '.');
    }
    return fillTheQueen(0, n, board);
  }

  public static void main(String[] args) {
    new LeetCode_52().totalNQueens(4);
  }
}
