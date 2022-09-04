package greedy;

import java.util.Arrays;

public class LeetCode_561 {

  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int total = 0;
    for (int i = nums.length - 2; i >- 1 ; i-=2) {
      total += nums[i];
    }
    return total;
  }

}
