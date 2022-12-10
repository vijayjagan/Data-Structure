package graph;

public class LeetCode_547 {

  static void dfsTraversal(int[][] isConnected, boolean[] isVisited, int row) {
    for (int i = 0; i < isConnected.length; i++) {
      if (!isVisited[i] && isConnected[row][i] == 1) {
        isVisited[i] = true;
        dfsTraversal(isConnected, isVisited, i);
      }
    }
  }

  public static int findCircleNum(int[][] isConnected) {
    int totalVertex = isConnected.length;
    DisJoinSet disJoinSet = new DisJoinSet(totalVertex);
    int count = 0;
    for (int i = 0; i < totalVertex; i++) {
      for (int j = 0; j < isConnected[0].length; j++) {
        if (isConnected[i][j] == 1 && i != j) {
          disJoinSet.union(i, j);
        }
      }
    }
    for (int i = 0; i < totalVertex; i++) {
      count += disJoinSet.findUnion(i) == i ? 1 : 0;
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] grid = {
        {1, 1, 0},
        {1, 1, 0},
        {0, 0, 1}
    };
    System.out.println(findCircleNum(grid));
  }

}
