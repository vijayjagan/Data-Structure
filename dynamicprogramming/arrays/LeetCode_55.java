package dynamicprogramming.arrays;

import java.util.Arrays;

public class LeetCode_55 {


  static boolean canJump(int index, int[] nums, Boolean[] cache) {

    if (index == nums.length - 1) {
      return true;
    }

    if (index >= nums.length || nums[index] == 0) {
      return false;
    }

    if (cache[index] != null) {
      return cache[index];
    }

    boolean allJump = false;

    for (int i = 1; i <= nums[index]; i++) {
      allJump = allJump || canJump(index + i, nums, cache);
      if (allJump) {
        cache[index] = allJump;
      }
    }

    return cache[index] = allJump;
  }

  static boolean tabulation(int[] nums) {
    boolean[] cache = new boolean[nums.length];
    cache[nums.length - 1] = true;
    for (int index = nums.length - 2; index > -1; index--) {
      boolean allJump = false;
      for (int i = 1; i <= nums[index]; i++) {
        allJump =  cache[index + i];
        if (allJump) {
          return true;
        }
      }
      cache[index] = allJump;
    }
    return cache[0];
  }

  public static boolean canJump(int[] nums) {
    Boolean[] cache = new Boolean[nums.length];
    return canJump(0,nums, cache);
  }

  public static void main(String[] args) {
    int[] nums = {2, 0};
    System.out.println(canJump(nums));
  }
}
