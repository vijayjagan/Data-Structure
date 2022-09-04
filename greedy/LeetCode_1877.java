package greedy;

import java.util.Arrays;

public class LeetCode_1877 {

  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int max = Integer.MIN_VALUE;
    for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
      max = Math.max(max, nums[i] + nums[j]);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {4, 1, 5, 1, 2, 5, 1, 5, 5, 4};
    int result = new LeetCode_1877().minPairSum(nums);
    System.out.println(result);
  }
}
