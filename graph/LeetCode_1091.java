package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LeetCode_1091 {

  class Pair {

    int distance;

    int[] location;

    public Pair(int distance, int[] location) {
      this.distance = distance;
      this.location = location;
    }
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int rowLength = grid.length;
    int colLength = grid[0].length;

    if (grid[0][0] == 1 || grid[rowLength - 1][colLength - 1] == 1) {
      return -1;
    }

    int[][] distance = new int[rowLength][colLength];
    for (int[] value : distance) {
      Arrays.fill(value, (int) 1e9);
    }
    Queue<Pair> bfs = new ArrayDeque<>();
    distance[0][0] = 1;
    bfs.add(new Pair(1, new int[]{0, 0}));

    int[][] eightDirection = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    while (!bfs.isEmpty()) {
      Pair pair = bfs.poll();
      int[] matrix = pair.location;
      int weight = pair.distance;
      int row = matrix[0];
      int col = matrix[1];

      for (int[] combination : eightDirection) {
        int nextRow = row + combination[0];
        int nextCol = col + combination[1];
        if (nextRow >= 0 && nextCol >= 0 && nextRow < rowLength && nextCol < colLength
            && distance[nextRow][nextCol] > weight + 1 && grid[nextRow][nextCol] == 0) {
          distance[nextRow][nextCol] = weight + 1;
          bfs.offer(new Pair(weight + 1, new int[]{nextRow, nextCol}));
        }
      }
    }
    return distance[rowLength - 1][colLength - 1] == 1e9 ? -1
        : distance[rowLength - 1][colLength - 1];
  }

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {0}
    };
    System.out.println(new LeetCode_1091().shortestPathBinaryMatrix(grid));
  }

}
