package greedy;

public class LeetCode_807 {


  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int buildingValue = 0;
    int[] maxRow = new int[grid.length];
    int[] maxColumn = new int[grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        maxRow[i] = Math.max(grid[i][j], maxRow[i]);
      }
    }

    for (int i = 0; i < grid[0].length; i++) {
      for (int[] ints : grid) {
        maxColumn[i] = Math.max(maxColumn[i], ints[i]);
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        buildingValue += Math.abs(grid[i][j] - Math.min(maxRow[i], maxColumn[j]));
      }
    }
    return buildingValue;
  }

}
