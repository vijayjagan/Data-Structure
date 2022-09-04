package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_51 {


  List<List<String>> queenList;

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


  void fillTheQueen(int row, int boardSize, char[][] board) {
    if (row == boardSize) {
      List<String> localBoard = new ArrayList<>();
      for (char[] value : board) {
        localBoard.add(new String(value));
      }
      queenList.add(new ArrayList<>(localBoard));
    }

    for (int i = 0; i < boardSize; i++) {
      if (canWePlaceTheQueen(row, i, boardSize, board)) {
        board[row][i] = 'Q';
        fillTheQueen(row + 1, boardSize, board);
        board[row][i] = '.';
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {
    queenList = new ArrayList<>();
    char[][] board = new char[n][n];
    for (char[] value : board) {
      Arrays.fill(value, '.');
    }
    fillTheQueen(0, n, board);
    System.out.println(queenList);
    return queenList;
  }

  public static void main(String[] args) {
    new LeetCode_51().solveNQueens(4);
  }

}
