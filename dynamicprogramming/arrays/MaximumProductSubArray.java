package dynamicprogramming.arrays;

public class MaximumProductSubArray {

  public static int maxProduct(int[] nums) {
    int result = nums[0];
    int localMax = nums[0];
    int localMin = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = localMin;
        localMin = localMax;
        localMax = temp;
      }
      localMax = Math.max(nums[i], nums[i] * localMax);
      localMin = Math.min(nums[i], nums[i] * localMin);
      result = Math.max(result, localMax);
    }
    return result;
  }


  public static void main(String[] args) {
    int [] nums = {3, 2, -1};
    System.out.println(maxProduct(nums));
  }
}
