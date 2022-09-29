package Array;

public class LeetCode_985 {

  public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

    int totalValue = 0;
    for (int num : nums) {
      if (num % 2 == 0) {
        totalValue += num;
      }
    }
    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int index = queries[i][1];
      boolean isOdd = nums[index] % 2 != 0;
      int prevValue = nums[index];
      nums[index] = nums[index] + queries[i][0];
      boolean isEven = nums[index] % 2 == 0;
      if (!isOdd && isEven) {
        totalValue = (totalValue - prevValue) + nums[index];
      } else if (!isOdd) {
        totalValue = totalValue - prevValue;
      } else if (isEven) {
        totalValue += nums[index];
      }
      result[i] = totalValue;
    }
    return result;
  }
}
