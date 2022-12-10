package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_1334 {


  public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] multiSource = new int[n][n];

    for (int[] vertex : multiSource) {
      Arrays.fill(vertex, (int) 1e9);
    }

    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      int weight = edge[2];
      multiSource[from][to] = multiSource[to][from] = weight;
    }

    for (int i = 0; i < n; i++) {
      multiSource[i][i] = 0;
    }

    for (int via = 0; via < n; via++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          multiSource[i][j] = Math.min(multiSource[i][via] + multiSource[via][j],
              multiSource[i][j]);
        }
      }
    }

    int lowestCity = -1;
    int cityCount = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int localCount = 0;
      for (int j = 0; j < n; j++) {
        if (multiSource[i][j] <= distanceThreshold) {
          localCount++;
        }
      }
      if (cityCount >= localCount) {
        lowestCity = i;
        cityCount = localCount;
      }
    }
    return lowestCity;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {0, 1, 2},
        {0, 4, 8},
        {1, 2, 3},
        {1, 4, 2},
        {2, 3, 1},
        {3, 4, 1}
    };
    System.out.println(findTheCity(5, matrix, 2));
  }

}
