package dynamicprogramming.lis;

import java.util.ArrayList;
import java.util.Arrays;


public class LeetCode_334 {

  public static boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    for (int value : nums) {
      if (value <= first) {
        first = value;
      } else if (second >= value) {
        second = value;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int [] nums = {5,4,3,2,1};
    System.out.println(increasingTriplet(nums));
  }
}
