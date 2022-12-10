package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LeetCode_1631 {

  class Pair {

    int effort;
    int[] coordinates;

    public Pair(int effort, int[] coordinates) {
      this.effort = effort;
      this.coordinates = coordinates;
    }
  }

  public int minimumEffortPath(int[][] heights) {
    int rowLength = heights.length;
    int colLength = heights[0].length;
    int[][] efforts = new int[rowLength][colLength];
    for (int[] effort : efforts) {
      Arrays.fill(effort, (int) 1e9);
    }
    Queue<Pair> bfs = new ArrayDeque<>();
    efforts[0][0] = 0;
    bfs.add(new Pair(0, new int[]{0, 0}));

    int[][] fourDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    while (!bfs.isEmpty()) {
      Pair pair = bfs.poll();
      int effort = pair.effort;
      int row = pair.coordinates[0];
      int col = pair.coordinates[1];
      if (row == rowLength - 1 && col == colLength - 1) {
        return effort;
      }
      for (int[] direction : fourDirections) {
        int nextRow = direction[0] + row;
        int nextCol = direction[1] + col;
        if (nextRow < rowLength && nextRow > -1 && nextCol < colLength && nextCol > -1) {
          int maxEffort = Math.max(Math.abs(heights[row][col] - heights[nextRow][nextCol]), effort);
          if (efforts[nextRow][nextCol] > maxEffort) {
            efforts[nextRow][nextCol] = maxEffort;
            bfs.add(new Pair(maxEffort, new int[]{nextRow, nextCol}));
          }
        }
      }
    }
    return efforts[rowLength - 1][colLength - 1];
  }

  public static void main(String[] args) {
    int[][] heights = new int[][]{
        {1, 2, 3},
        {3, 8, 4},
        {5, 3, 5}
    };
    System.out.println(new LeetCode_1631().minimumEffortPath(heights));
  }
}
