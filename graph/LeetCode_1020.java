package graph;

public class LeetCode_1020 {

  void markBoundaryConnectedData(int row, int column, int rLength, int cLength, int[][] grid) {
    if (row < 0 || column < 0 || row >= rLength || column >= cLength || grid[row][column] != 1) {
      return;
    }
    grid[row][column] = -1;
    markBoundaryConnectedData(row + 1, column, rLength, cLength, grid);
    markBoundaryConnectedData(row - 1, column, rLength, cLength, grid);
    markBoundaryConnectedData(row, column + 1, rLength, cLength, grid);
    markBoundaryConnectedData(row, column - 1, rLength, cLength, grid);
  }


  public int numEnclaves(int[][] grid) {
    int rowLength = grid.length;
    int colLength = grid[0].length;

    // Upper and lower Boundaries
    for (int i = 0; i < colLength; i++) {
      if (grid[0][i] == 1) {
        markBoundaryConnectedData(0, i, rowLength, colLength, grid);
      }
      if (grid[rowLength - 1][i] == 1) {
        markBoundaryConnectedData(rowLength - 1, i, rowLength, colLength, grid);
      }
    }

    // Left and Right Boundaries
    for (int i = 0; i < rowLength; i++) {
      if (grid[i][0] == 1) {
        markBoundaryConnectedData(i, 0, rowLength, colLength, grid);
      }
      if (grid[i][colLength - 1] == 1) {
        markBoundaryConnectedData(i, colLength - 1, rowLength, colLength, grid);
      }
    }

    int count = 0;
    for (int[] ints : grid) {
      for (int j = 0; j < colLength; j++) {
        if (ints[j] == 1) {
          count++;
        }
      }
    }
    return count;
  }

}
