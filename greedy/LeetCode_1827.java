package greedy;

public class LeetCode_1827 {


  public static int minOperations(int[] nums) {
    int count = 0;
    int prev = nums[0];
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        continue;
      }
      int newValue = nums[i] + 1;
      count += Math.abs(newValue - nums[i + 1]);
      nums[i + 1] = newValue;
    }
    return count;
  }


  public static void main(String[] args) {
    int[] nums = {1, 5, 2, 4, 1};
    System.out.println(minOperations(nums));
  }
}
