package dynamicprogramming.coinchange;

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
      result = (result + rollsToTarget(n - 1, k, target - i, cache)) % (1000000000 + 7);
    }

    return cache[n][target] = result;
  }

  public static int numRollsToTarget(int n, int k, int target) {
    int length = Math.max(n, target);
    Integer[][] cache = new Integer[length + 1][length + 1];
    return rollsToTarget(n, k, target, cache);
  }

  public static void main(String[] args) {
    System.out.println(numRollsToTarget(30, 30, 500));
  }
}
