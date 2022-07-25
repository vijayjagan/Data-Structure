package dynamicprogramming.mcm;

public class BurstBalloons {

  public static int maximumCoins(int left, int right, int[] nums, Integer[][] cache) {
    if (left > right) {
      return 0;
    }
    if (cache[left][right] != null) {
      return cache[left][right];
    }
    int maximumCoins = -1;
    for (int i = left; i <= right; i++) {
      int leftPartition = maximumCoins(left, i - 1, nums, cache);
      int currentCost = nums[left - 1] * nums[i] * nums[right + 1];
      int rightPartition = maximumCoins(i + 1, right, nums, cache);
      maximumCoins = Math.max(maximumCoins, leftPartition + currentCost + rightPartition);
    }
    return cache[left][right] = maximumCoins;
  }


  public int maxCoins(int[] nums) {
    int[] imaginaryCoins = new int[nums.length + 2];
    imaginaryCoins[0] = 1;
    System.arraycopy(nums, 0, imaginaryCoins, 1, nums.length);
    imaginaryCoins[nums.length + 1] = 1;
    int[][] cache = new int[imaginaryCoins.length][imaginaryCoins.length];
    for (int left = nums.length; left > 0; left--) {
      for (int right = 1; right <= nums.length; right++) {
        int maximumCoins = -1;
        if (left > right) {
          continue;
        }
        for (int i = left; i <= right; i++) {
          int leftPartition = cache[left][i - 1];
          int currentCost =
              imaginaryCoins[left - 1] * imaginaryCoins[i] * imaginaryCoins[right + 1];
          int rightPartition = cache[i + 1][right];
          maximumCoins = Math.max(maximumCoins, leftPartition + currentCost + rightPartition);
        }
        cache[left][right] = maximumCoins;
      }
    }
    return cache[1][nums.length];
  }
}
