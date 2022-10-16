package graph;

public class LeetCode_547 {

  static void dfsTraversal(int [][] isConnected, boolean[] isVisited, int row) {
    for (int i = 0; i < isConnected.length; i++) {
      if (!isVisited[i] && isConnected[row][i] == 1) {
        isVisited[i] = true;
        dfsTraversal(isConnected, isVisited, i);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    int totalVertex = isConnected.length;
    boolean [] visited = new boolean[totalVertex];
    int count = 0;

    for (int i = 0; i < totalVertex; i++) {
      if (!visited[i]) {
        count ++;
        dfsTraversal(isConnected, visited, i);
      }
    }
    return count;
  }

}
