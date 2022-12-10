package graph;

public class FloyddMarshall {


  public void shortest_distance(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          matrix[i][j] = 0;
        } else if (matrix[i][j] == -1) {
          matrix[i][j] = (int) 1e9;
        }
      }
    }

    for (int via = 0; via < m; via++) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = Math.min(matrix[i][via] + matrix[via][j], matrix[i][j]);
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1e9) {
          matrix[i][j] = -1;
        }
      }
    }
  }

}
