package dynamicprogramming.grids;

import java.util.Arrays;

public class MinimumFallingPath {

  static int min(int var1, int var2, int var3) {
    return Math.min(var1, Math.min(var2, var3));
  }

  static int minimumFallingPath(int row, int column, int[][] matrix, int[][] cache) {
    int m = matrix.length;
    int n = matrix[0].length;

    if (row == m || row < 0 || column < 0 || column == n) {
      return (int) Math.pow(10, 9);
    }

    if (cache[row][column] != -1) {
      return cache[row][column];
    }

    if (row == m - 1 && column < n) {
      return cache[row][column] = matrix[row][column];
    }

    int belowRow = minimumFallingPath(row + 1, column, matrix, cache);
    int leftDiagonal = minimumFallingPath(row + 1, column - 1, matrix, cache);
    int rightDiagonal = minimumFallingPath(row + 1, column + 1, matrix, cache);
    return cache[row][column] = matrix[row][column] + min(rightDiagonal, belowRow, leftDiagonal);
  }

  public int minFallingPathSum(int[][] matrix) {
    int min = Integer.MAX_VALUE;
    int[][] cache = new int[matrix.length][matrix[0].length];

    for (int[] value : cache) {
      Arrays.fill(value, -1);
    }

    for (int i = 0; i < matrix[0].length; i++) {
      min = Math.min(min, minimumFallingPath(0, i, matrix, cache));
    }
    return min;
  }

  public static void main(String[] args) {
    int[][] matrix = {
        {2, 1, 3},
        {6, 5, 4},
        {7, 8, 9},
    };
    System.out.println(new MinimumFallingPath().minFallingPathSum(matrix));
  }
}
