package graph;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_733 {

  class Pair {

    int row;
    int column;

    public Pair(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    Queue<Pair> breadthFirst = new LinkedList<>();
    breadthFirst.offer(new Pair(sr, sc));
    int srcColor = image[sr][sc];
    int rowLength = image.length;
    int columnLength = image[0].length;
    boolean[][] visited = new boolean[rowLength][columnLength];

    while (!breadthFirst.isEmpty()) {
      Pair pair = breadthFirst.poll();
      int row = pair.row;
      int column = pair.column;
      image[row][column] = color;
      visited[row][column] = true;

      if (row + 1 < rowLength && image[row + 1][column] == srcColor && !visited[row + 1][column]) {
        breadthFirst.offer(new Pair(row + 1, column));
      }

      if (row - 1 > -1 && image[row - 1][column] == srcColor && !visited[row - 1][column]) {
        breadthFirst.offer(new Pair(row - 1, column));
      }

      if (column + 1 < columnLength && image[row][column + 1] == srcColor && !visited[row][column
          + 1]) {
        breadthFirst.offer(new Pair(row, column + 1));
      }

      if (column - 1 > -1 && image[row][column - 1] == srcColor && !visited[row][column - 1]) {
        breadthFirst.offer(new Pair(row, column - 1));
      }
    }
    return image;
  }

}
