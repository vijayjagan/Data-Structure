package graph;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_542 {


  public int[][] updateMatrix(int[][] mat) {
    int rowLength = mat.length;
    int colLength = mat[0].length;
    Queue<int[]> zerosQueue = new LinkedList<>();
    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        if (mat[i][j] == 0) {
          zerosQueue.offer(new int[]{i, j});
        } else {
          mat[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    int[][] possibleNeighbours = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!zerosQueue.isEmpty()) {
      int[] matrix = zerosQueue.poll();
      int row = matrix[0];
      int col = matrix[1];

      for (int[] neighbour : possibleNeighbours) {
        int neighbourRow = neighbour[0] + row;
        int neighbourCol = neighbour[1] + col;
        if (neighbourRow < 0 || neighbourCol < 0 || neighbourRow >= rowLength
            || neighbourCol >= colLength
            || mat[neighbourRow][neighbourCol] <= mat[row][col] + 1) {
          continue;
        }
        mat[neighbourRow][neighbourCol] = mat[row][col] + 1;
        zerosQueue.offer(new int[]{neighbourRow, neighbourCol});
      }
    }
    return mat;
  }

}
