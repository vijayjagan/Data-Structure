package graph;

public class LeetCode_200 {


  static void checkForIsland(char[][] grid, int row, int column, int rowLength, int columnLength) {
    if (row < 0 || row >= rowLength || column < 0 || column >= columnLength
        || grid[row][column] != '1') {
      return;
    }
    grid[row][column] = '-';
    checkForIsland(grid, row + 1, column, rowLength, columnLength);
    checkForIsland(grid, row - 1, column, rowLength, columnLength);
    checkForIsland(grid, row, column + 1, rowLength, columnLength);
    checkForIsland(grid, row, column - 1, rowLength, columnLength);
  }

  public static int numIslands(char[][] grid) {
    int length = grid.length;
    int count = 0;
    int columnLength = grid[0].length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < columnLength; j++) {
        if (grid[i][j] == '1') {
          count++;
          checkForIsland(grid, i, j, length, columnLength);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    char[][] island = new char[][]{
        {'1'},
        {'1'}
    };
    System.out.println(numIslands(island));
  }

}
