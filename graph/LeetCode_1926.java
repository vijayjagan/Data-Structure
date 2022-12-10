package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_1926 {


  static boolean isBorder(int row, int col, int m, int n, int[] entrance, Integer[][] visited) {
    if (row == 0 || col == 0 || row == m - 1 || col == n - 1) {
      return (visited[row][col] != null && (row != entrance[0] || col != entrance[1]));
    }
    return false;
  }

  public static int nearestExit(char[][] maze, int[] entrance) {
    int m = maze.length;
    int n = maze[0].length;

    Integer[][] visited = new Integer[m][n];
    Queue<int[]> bfs = new ArrayDeque<>();
    bfs.add(new int[]{entrance[0], entrance[1], 0});
    int[][] fourDirection = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!bfs.isEmpty()) {
      int[] data = bfs.poll();
      int row = data[0];
      int col = data[1];
      int step = data[2];
      if (isBorder(row, col, m, n, entrance, visited)) {
        return step;
      }
      for (int[] direction : fourDirection) {
        int nextR = row + direction[0];
        int nextC = col + direction[1];
        if (nextR > -1 && nextR < m && nextC > -1 && nextC < n
            && maze[nextR][nextC] == '.'
            && visited[nextR][nextC] == null) {
          visited[nextR][nextC] = step + 1;
          bfs.add(new int[]{nextR, nextC, step + 1});
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    char[][] maze = {
        {'+', '+', '.', '+'},
        {'.', '.', '.', '+'},
        {'+', '+', '+', '.'}
    };
    System.out.println(nearestExit(maze, new int[]{1, 2}));
  }

}
