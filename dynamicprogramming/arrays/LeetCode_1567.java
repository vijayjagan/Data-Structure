package dynamicprogramming.arrays;

public class LeetCode_1567 {


  /**
   * Calculate max length from left to right and right to left and return the max
   */

  public static int getMaxLen(int[] nums) {
    int start = 0;
    int end = 0;
    int product = 1;
    int maxCountFromLeft = 0, maxCountFromRight = 0;

    if (nums.length == 1) {
      return nums[0] <= 0 ? 0 : 1;
    }

    for (int i = 0; i < nums.length; i++) {
      product *= nums[i] < 0 ? -1 : 1;
      if (nums[i] == 0) {
        product = 1;
        start = i + 1;
        continue;
      }
      if (product > 0) {
        end = i;
      }
      maxCountFromLeft = Math.max(maxCountFromLeft, (end - start) + 1);
    }
    product = 1;
    start = nums.length - 1;
    end = nums.length - 1;
    for (int i = nums.length - 1; i > -1; i--) {
      product *= nums[i] < 0 ? -1 : 1;

      if (nums[i] == 0) {
        product = 1;
        end = i - 1;
        continue;
      }

      if (product > 0) {
        start = i;
      }
      maxCountFromRight = Math.max(maxCountFromRight, (end - start) + 1);
    }
    return Math.max(maxCountFromLeft, maxCountFromRight);
  }

  public static void main(String[] args) {
    int[] nums = {70, -18, 75, -72, -69, -84, 64, -65, 0, -82, 62, 54, -63, -85, 53, -60, -59, 29,
        32, 59, -54, -29, -45, 0, -10, 22, 42, -37, -16, 0, -7, -76, -34, 37, -10, 2, -59, -24, 85,
        45, -81, 56, 86};

    System.out.println(getMaxLen(nums));
  }

}
