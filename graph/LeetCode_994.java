package graph;

import graph.LeetCode_733.Pair;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_994 {

  class Rotten {
    int row;
    int column;
    int time;
    public Rotten(int row, int column, int time) {
      this.row = row;
      this.column = column;
      this.time = time;
    }
  }

  public int orangesRotting(int[][] grid) {
    // Code here
    Queue<Rotten> rottenQueue = new LinkedList<>();
    int minTime = 0;
    int freshOranges = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) {
          rottenQueue.add(new Rotten(i, j, 0));
        }
        if (grid[i][j] == 1) {
          freshOranges++;
        }
      }
    }

    if (freshOranges == 0) {
      return 0;
    }

    while (!rottenQueue.isEmpty()) {
      Rotten rottenPos = rottenQueue.poll();
      int row = rottenPos.row;
      int column = rottenPos.column;
      int time = rottenPos.time;
      if (row - 1 < grid.length && row - 1 >= 0 && column < grid[0].length && column >= 0) {
        if (grid[row - 1][column] == 1) {
          grid[row -1 ][column] = 2;
          rottenQueue.add(new Rotten(row - 1, column, time + 1));
          freshOranges--;
        }
      }
      if (row + 1 < grid.length && row + 1 >= 0 && column < grid[0].length && column >= 0) {
        if (grid[row + 1][column] == 1) {
          grid[row + 1][column] = 2;
          rottenQueue.add(new Rotten(row + 1, column, time + 1));
          freshOranges--;
        }
      }
      if (row < grid.length && row >= 0 && column - 1 < grid[0].length && column - 1 >= 0) {
        if (grid[row][column - 1] == 1) {
          grid[row][column - 1] = 2;
          rottenQueue.add(new Rotten(row, column - 1, time + 1));
          freshOranges--;
        }
      }
      if (row < grid.length && row >= 0 && column + 1 < grid[0].length && column + 1 >= 0) {
        if (grid[row][column + 1] == 1) {
          grid[row][column + 1] = 2;
          rottenQueue.add(new Rotten(row, column + 1, time + 1));
          freshOranges--;
        }
      }
      if (freshOranges == 0) {
        return time + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] rottenOranges = new int[][]{
        {2, 1, 1},
        {1, 1, 1},
        {0, 1, }
    };
    System.out.println(new LeetCode_994().orangesRotting(rottenOranges));
  }

}
