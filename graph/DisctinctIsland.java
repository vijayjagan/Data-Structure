package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisctinctIsland {

  void markConnectedIslands(int row, int column, int rowLength, int colLength, int[] base,
      int[][] grid, StringBuilder islandPath) {
    if (row < 0 || column < 0 || row >= rowLength || column >= colLength
        || grid[row][column] != 1) {
      return;
    }
    grid[row][column] = -1;
    islandPath.append(base[0] - row).append(base[1] - column);
    markConnectedIslands(row + 1, column, rowLength, colLength, base, grid, islandPath);
    markConnectedIslands(row - 1, column, rowLength, colLength, base, grid, islandPath);
    markConnectedIslands(row, column + 1, rowLength, colLength, base, grid, islandPath);
    markConnectedIslands(row, column - 1, rowLength, colLength, base, grid, islandPath);
  }

  int countDistinctIslands(int[][] grid) {
    int rowLength = grid.length;
    int colLength = grid[0].length;
    Set<String> distinctIslands = new HashSet<>();
    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        if (grid[i][j] == 1) {
          StringBuilder islandPath = new StringBuilder();
          markConnectedIslands(i, j, rowLength, colLength, new int[]{i, j}, grid, islandPath);
          distinctIslands.add(islandPath.toString());
        }
      }
    }
    return distinctIslands.size();
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1}
    };
    System.out.println(new DisctinctIsland().countDistinctIslands(grid));
  }
}
