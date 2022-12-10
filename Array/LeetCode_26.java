package Array;

import java.util.Arrays;

public class LeetCode_26 {

  public static int removeDuplicates(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        nums[i] = Integer.MAX_VALUE;
      }
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == Integer.MAX_VALUE) {
        return i - 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    removeDuplicates(arr);
    System.out.println(Arrays.toString(arr));
  }

}
