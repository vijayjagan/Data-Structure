package dynamicprogramming.mcm;

public class LeetCode_1000 {

  // stones = [3,2,4,1], k = 2


  public static int mergeStones(int[] stones, int K) {
    int l = stones.length;
    if (l == 1) return 0;
    if (K > l) return - 1;
    if ((stones.length - 1) % (K - 1) != 0) return -1;

    int[][] dp = new int[l][l];
    int[] preSum = new int[l];

    for (int i = 0; i < l; i++) preSum[i] = ((i == 0 ? 0 : preSum[i - 1]) + stones[i]);

    return mergingFromBottom(0, stones.length - 1, K, preSum, dp);
  }

  private static int mergingFromBottom(int start, int end, int k, int[] preSum, int[][] dp) {
    if (start > end)  {
      return 0;
    }
    int length = end - start + 1;

    if (length < k) {
      return 0;
    }
    if (length == k) {
      return preSum[end] - (start == 0 ? 0 : preSum[start - 1]);
    }

    if (dp[start][end] != 0) {
      return dp[start][end];
    }

    int min = Integer.MAX_VALUE;
    for (int i = start; i < end; i += k - 1) {
      int leftPartition = mergingFromBottom(start, i, k, preSum, dp);
      int rightPartition = mergingFromBottom(i + 1, end, k, preSum, dp);
      min = Math.min(min, leftPartition + rightPartition);
    }

    if ((length - 1) % (k - 1) == 0) {
      min += preSum[end] - (start == 0 ? 0 : preSum[start - 1]);
    }

    return dp[start][end] = min;
  }


  public static void main(String[] args) {
    int[] stones = {3,2,4};
    System.out.println(mergeStones(stones, 2));
  }
}
