package dynamicprogramming.mcm;

public class LeetCode_1000 {

  // stones = [3,2,4,1], k = 2


  public static int mergeStones(int[] stones, int K) {
    int l = stones.length;
    if (l == 1) {
      return 0;
    }
    if (K > l) {
      return -1;
    }
    if ((stones.length - 1) % (K - 1) != 0) {
      return -1;
    }

    int[][] dp = new int[l][l];
    int[] preSum = new int[l];

    for (int i = 0; i < l; i++) {
      preSum[i] = ((i == 0 ? 0 : preSum[i - 1]) + stones[i]);
    }

    return mergingFromBottom(0, stones.length - 1, K, preSum, dp);
  }

  private static int mergingFromBottom(int left, int right, int k, int[] preSum, int[][] dp) {
    if (left >= right) {
      return 0;
    }

    if (dp[left][right] != 0) {
      return dp[left][right];
    }

    int min = Integer.MAX_VALUE;
    // k - 1 Since all the value is merged to one, that's the reason for k - 1
    // K piles will be merged and k - 1 index is the merged index
    for (int i = left; i < right; i += k - 1) {
      int mergeCost = 0;
      if ((right - left) % (k - 1) == 0) {
        mergeCost = preSum[right] - (left == 0 ? 0 : preSum[left - 1]);
      }
      int leftPartition = mergingFromBottom(left, i, k, preSum, dp);
      int rightPartition = mergingFromBottom(i + 1, right, k, preSum, dp);
      min = Math.min(min, leftPartition + rightPartition + mergeCost);
    }

    return dp[left][right] = min;
  }


  public static void main(String[] args) {
    int[] stones = {3, 5, 2, 1, 6};
    System.out.println(mergeStones(stones, 3));
  }
}
