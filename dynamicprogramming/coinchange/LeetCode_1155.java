package dynamicprogramming.coinchange;

import java.util.Arrays;

public class LeetCode_1155 {

  static int rollsToTarget(int n, int k, int target, Integer[][] cache) {

    if (target == 0 && n == 0) {
      return 1;
    }

    if (target < 0 || n == 0) {
      return 0;
    }

    if (cache[n][target] != null) {
      return cache[n][target];
    }

    int result = 0;

    for (int i = 1; i <= k; i++) {
      result = (result + rollsToTarget(n - 1, k, target - i, cache)) % (1000000007);
    }

    return cache[n][target] = result;
  }

  static int tabulation(int n, int k, int target) {
    int length = Math.max(n, target);
    int[][] cache = new int[length + 1][length + 1];

    // Base Case
    cache[0][0] = 1;

    for (int dice = 1; dice <= n; dice++) {
      for (int localTarget = 1; localTarget <= target; localTarget++) {
        int result = 0;
        for (int rolling = 1; rolling <= k; rolling++) {
          if (localTarget - rolling < 0) {
            continue;
          }
          result = (result + cache[dice - 1][localTarget - rolling]) % 1000000007;
        }
        cache[dice][localTarget] = result;
      }
    }

    return cache[n][target];
  }

  public static int numRollsToTarget(int n, int k, int target) {
    return tabulation(n, k ,target);
  }

  public static void main(String[] args) {
    System.out.println(numRollsToTarget(30, 30, 500));
  }
}
