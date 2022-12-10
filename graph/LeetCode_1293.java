package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_1293 {

  public static int shortestPath(int[][] grid, int k) {
    int rowLength = grid.length;
    int colLength = grid[0].length;
    int[][] distance = new int[rowLength][colLength];
    for (int[] vertex : distance) {
      Arrays.fill(vertex, (int) 1e9);
    }
    Queue<int[]> bfs = new ArrayDeque<>();

    distance[0][0] = 0;
    bfs.offer(new int[]{0, 0, 0, 0});

    while (!bfs.isEmpty()) {
      int[] data = bfs.poll();
      int row = data[0];
      int col = data[1];
      int weight = data[2];
      int wall = data[3];

      if (row == rowLength - 1 && col == colLength - 1) {
        return weight;
      }

      int[][] fourDirection = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

      for (int[] neighbours : fourDirection) {
        int nextRow = row + neighbours[0];
        int nextCol = col + neighbours[1];
        if (nextRow > -1 && nextCol > -1 && nextRow < rowLength && nextCol < colLength
            && distance[nextRow][nextCol] > weight + 1) {
          boolean isWallPresent = grid[nextRow][nextCol] == 1;
          if (isWallPresent && wall + 1 <= k) {
            distance[nextRow][nextCol] = weight + 1;
            bfs.offer(new int[]{nextRow, nextCol, distance[nextRow][nextCol], wall + 1});
          } else if (!isWallPresent) {
            distance[nextRow][nextCol] = weight + 1;
            bfs.offer(new int[]{nextRow, nextCol, distance[nextRow][nextCol], wall});
          }
        }
      }
    }

    if (distance[rowLength - 1][colLength - 1] == 1e9) {
      return -1;
    }
    return distance[rowLength - 1][colLength - 1];
  }

  public static void main(String[] args) {
    int[][] grid = {
        {0, 1, 0, 0, 0, 1, 0, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 1, 0}
    };
    System.out.println(shortestPath(grid, 1));
  }

}
