package dynamicprogramming.lis;

import java.util.ArrayList;
import java.util.Arrays;


public class LeetCode_334 {

  public static boolean increasingTriplet(int[] nums) {
    int n = nums.length;
    if (n < 3) {
      return false;
    }
    int num1 = nums[0], num2 = Integer.MAX_VALUE;

    for (int i = 1; i < n; i++) {
      if (num1 > nums[i]) {
        num1 = nums[i];
      } else if (num2 >= nums[i]) {
        num2 = nums[i];
      } else {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    System.out.println(increasingTriplet(nums));
  }
}
