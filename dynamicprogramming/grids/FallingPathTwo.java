package dynamicprogramming.grids;

import java.util.Arrays;

public class FallingPathTwo {

  static int minimumFallingPath(int row, int column, int[][] matrix,
      int[][] cache) {

    int m = matrix.length;
    int n = matrix[0].length;

    if (row == m) {
      return (int) Math.pow(10, 9);
    }

    if (cache[row][column] != -1) {
      return cache[row][column];
    }

    if (row == m - 1) {
      return cache[row][column] = matrix[row][column];
    }

    int nextSet = (int) Math.pow(10, 9);

    for (int i = 0; i < n; i++) {
      if (i == column) {
        continue;
      }
      nextSet = Math.min(nextSet, minimumFallingPath(row + 1, i, matrix, cache));
    }

    return cache[row][column] = matrix[row][column] + nextSet;
  }

   int minimumFallingPathTabulation(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] cache = new int[grid.length][grid[0].length];

    System.arraycopy(grid[m - 1], 0, cache[m - 1], 0, n);

    for (int row = m - 2; row > -1; row--) {
      for (int column = n-1; column > -1; column--) {
        int nextSet = (int) Math.pow(10, 9);
        for (int i = 0; i < n; i++) {
          if (i == column) {
            continue;
          }
          nextSet = Math.min(nextSet, cache[row + 1][i]);
        }
        cache[row][column] = nextSet + grid[row][column];
      }
    }
    int result = cache[0][0];
    for (int i = 1; i < n; i++) {
      result = Math.min(result, cache[0][i]);
    }

    for (int []values : cache) {
      for (int value : values) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
    return result;
  }

  public int minFallingPathSum(int[][] grid) {
    int min = Integer.MAX_VALUE;
    int[][] cache = new int[grid.length][grid[0].length];

    for (int[] value : cache) {
      Arrays.fill(value, -1);
    }

    for (int i = 0; i < grid[0].length; i++) {
      min = Math.min(min, minimumFallingPath(0, i, grid, cache));
    }

    return min;
  }

  public static void main(String[] args) {
    int[][] matrix = {
        {-1, -2},
        {4, 5},
    };
    System.out.println(new FallingPathTwo().minimumFallingPathTabulation(matrix));
  }

}
