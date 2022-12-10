package dynamicprogramming.grids;

import java.util.Arrays;

public class LeetCode_1706 {


  static int findBall(int r, int c, int[][] grid, int rL, int cL) {

    if (r == rL) {
      return c;
    }

    if (grid[r][c] == 1 && c + 1 < cL && grid[r][c + 1] == 1) {
      return findBall(r + 1, c + 1, grid, rL, cL);
    } else if (grid[r][c] == -1 && c - 1 > -1 && grid[r][c - 1] == -1) {
      return findBall(r + 1, c - 1, grid, rL, cL);
    }
    return -1;
  }

  public static int[] findBall(int[][] grid) {
    int r = grid.length;
    int c = grid[0].length;
    int[] drop = new int[c];

    for (int i = 0; i < c; i++) {
      drop[i] = findBall(0, i, grid, r, c);
    }
    return drop;
  }

  public static void main(String[] args) {
    int[][] grid = {
        {1, 1}
    };
//    int[][] grid = {
//        {1, 1, 1, 1, 1, 1},
//        {-1, -1, -1, -1, -1, -1},
//        {1, 1, 1, 1, 1, 1},
//        {-1, -1, -1, -1, -1, -1}
//    };
    System.out.println(Arrays.toString(findBall(grid)));
  }

}
