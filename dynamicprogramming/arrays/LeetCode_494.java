package dynamicprogramming.arrays;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_494 {


  static int findTargetSumWays(int[] nums, int target, int n,
      Map<String, Integer> cacheMap) {
    if (n == -1) {
      return target == 0 ? 1 : 0;
    }
    if (cacheMap.containsKey(target + "#" + n)) {
      return cacheMap.get(target + "#" + n);
    }
    int totalWays = 0;
    totalWays += findTargetSumWays(nums, target - nums[n], n - 1, cacheMap);
    totalWays += findTargetSumWays(nums, target + nums[n], n - 1, cacheMap);
    cacheMap.put(target + "#" + n, totalWays);
    return totalWays;
  }


  public int findTargetSumWays(int[] nums, int target) {
    Map<String, Integer> cacheMap = new HashMap<>();
    return findTargetSumWays(nums, target, nums.length - 1, cacheMap);
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1, 1};
    System.out.println(new LeetCode_494().findTargetSumWays(nums, 3));
  }
}
