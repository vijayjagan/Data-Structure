package greedy;

import java.util.Arrays;

public class LeetCode_16 {

  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));

    int lowerBound = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < nums.length - 2; i++) {
      int secondPointer = i + 1;
      int thirdPointer = nums.length - 1;

      while (secondPointer < thirdPointer) {
        int sum = nums[i] + nums[secondPointer] + nums[thirdPointer];

        if (sum == target) {
          return sum;
        }

        if (Math.abs(lowerBound - target) > Math.abs(sum - target)) {
          lowerBound = sum;
        }

        if (sum < target) {
          secondPointer++;
        } else {
          thirdPointer--;
        }
      }
    }
    return lowerBound;
  }

  public static void main(String[] args) {
    int[] nums = {-4, -1, 1, 2};
    System.out.println(threeSumClosest(nums, 1));
  }

}
