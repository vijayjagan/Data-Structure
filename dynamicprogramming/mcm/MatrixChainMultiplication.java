package dynamicprogramming.mcm;

import jdk.jfr.Description;

public class MatrixChainMultiplication {

  @Description("Solved using Recursion + Memoization")
  static int matrixMultiplication(int leftPointer, int rightPointer, int[] arr, Integer[][] dp) {
    if (leftPointer == rightPointer) {
      return 0;
    }
    if (dp[leftPointer][rightPointer] != null) {
      return dp[leftPointer][rightPointer];
    }
    int min = Integer.MAX_VALUE;
    for (int i = leftPointer; i < rightPointer; i++) {
      // Freeze the LeftPointer since it's expanding in Righ-hand side
      int leftPartition = matrixMultiplication(leftPointer, i, arr, dp);
      // Freeze the RightPointer since it's shrinking from Left-Hand side
      int rightPartition = matrixMultiplication(i + 1, rightPointer, arr, dp);
      int currentComputation = arr[leftPointer - 1] * arr[i] * arr[rightPointer];
      min = Math.min(min, currentComputation + leftPartition + rightPartition);
    }
    return dp[leftPointer][rightPointer] = min;
  }


  @Description("Solved Using Tabulation Method")
  static int matrixMultiplicationInTabulation(int N, int[] arr) {
    int[][] dp = new int[N][N];
    for (int leftPointer = N - 1; leftPointer > 0; leftPointer--) {
      for (int rightPointer = leftPointer + 1; rightPointer < N; rightPointer++) {
        int min = Integer.MAX_VALUE;
        for (int i = leftPointer; i < rightPointer; i++) {
          // Freeze the LeftPointer since it's expanding in Righ-hand side
          int leftPartition = dp[leftPointer][i];
          // Freeze the RightPointer since it's shrinking from Left-Hand side
          int rightPartition = dp[i + 1][rightPointer];
          int currentComputation = arr[leftPointer - 1] * arr[i] * arr[rightPointer];
          min = Math.min(min, currentComputation + leftPartition + rightPartition);
        }
        dp[leftPointer][rightPointer] = min;
      }
    }
    return dp[1][N - 1];
  }

  public static int matrixMultiplication(int N, int[] arr) {
    // code here
    Integer[][] dp = new Integer[N][N];
    return matrixMultiplication(1, N - 1, arr, dp);
  }

  public static void main(String[] args) {
    int[] n = {10, 30, 5, 60};
    System.out.println(matrixMultiplication(n.length, n));
  }

}
