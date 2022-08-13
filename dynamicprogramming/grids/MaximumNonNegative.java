package dynamicprogramming.grids;

public class MaximumNonNegative {

  static long maximumNonNegative(int row, int column, int[][] grid) {
    int lastRow = grid.length;
    int lastColumn = grid[0].length;

    // Out Of Bounds
    if (row >= lastRow || column >= lastColumn) {
      return Integer.MIN_VALUE;
    }

    if (row == lastRow - 1 && column == lastColumn - 1) {
      return grid[row][column];
    }

    long maxProduct = Integer.MIN_VALUE / 4;

    long result =
        Math.max(grid[row][column] * maximumNonNegative(row, column + 1, grid), grid[row][column] *
            maximumNonNegative(row + 1, column, grid));

    return Math.max(maxProduct, result);
  }

  public static int maxProductPath(int[][] grid) {
    int mod = 1000000007;
    long product = maximumNonNegative(0, 0, grid);
    return (int) (product % mod);
  }

  public static void main(String[] args) {
    int[][] grid = {
        {1, -2, 1},
        {1, -2, 1},
        {3, -4, 1}
    };

//    int[][] grid = {
//        {1, 3},
//        {0, -4}
//    };
    System.out.println(maxProductPath(grid));
  }
}
