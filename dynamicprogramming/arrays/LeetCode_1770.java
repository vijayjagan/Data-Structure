package dynamicprogramming.arrays;

import java.util.Arrays;

public class LeetCode_1770 {


  static int maximumScore(int sIndex, int mIndex, int[] nums, int[] multipliers,
      Integer[][] cache) {

    if (mIndex == multipliers.length) {
      return 0;
    }

    if (cache[sIndex][mIndex] != null) {
      return cache[sIndex][mIndex];
    }

    int fromStart =
        (nums[sIndex] * multipliers[mIndex]) + maximumScore(sIndex + 1, mIndex + 1, nums,
            multipliers, cache);

    int eIndex = nums.length - 1 - mIndex + sIndex;

    int fromEnd = (nums[eIndex] * multipliers[mIndex]) + maximumScore(sIndex , mIndex + 1, nums,
        multipliers, cache);

    return cache[sIndex][mIndex] = Math.max(fromEnd, fromStart);
  }


  public int maximumScore(int[] nums, int[] multipliers) {
    Integer[][] cache = new Integer[multipliers.length][multipliers.length];
    return maximumScore(0, 0, nums, multipliers, cache);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    int[] multipliers = {3, 2};

    System.out.println(new LeetCode_1770().maximumScore(nums, multipliers));
  }

}
