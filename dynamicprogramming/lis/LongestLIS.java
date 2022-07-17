package dynamicprogramming.lis;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LongestLIS {

  static int lengthOfLiS(int index, int prevIndex, int[] nums, int[][] dp) {
    if (index == nums.length) {
      return 0;
    }
    if (dp[index][prevIndex + 1] != -1) {
      return dp[index][prevIndex];
    }
    int pick = 0;
    if (prevIndex == 0 || nums[prevIndex + 1] < nums[index]) {
      pick = 1 + lengthOfLiS(index + 1, index, nums, dp);
    }
    int notPick = lengthOfLiS(index + 1, prevIndex, nums, dp);
    return dp[index][prevIndex] = Math.max(pick, notPick);
  }


  public int lengthOfLongestIncreasingSubsequence(int[] nums) {
    int[] tracker = new int[nums.length];
    Arrays.fill(tracker, 1);
    int max = -1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && tracker[i] < tracker[j] + 1) {
          tracker[i] = tracker[j] + 1;
        }
      }
      max = Math.max(tracker[i], max);
    }
    return max;
  }


  public static void printLengthOfLongestIncreasingSubsequence(int[] nums) {
    int[] tracker = new int[nums.length];
    Arrays.fill(tracker, 1);
    int max = -1;
    int lastIndex = 0;
    int[] indexTracker = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      indexTracker[i] = i;
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && tracker[i] < tracker[j] + 1) {
          tracker[i] = tracker[j] + 1;
          indexTracker[i] = j;
        }
      }
      if (tracker[i] > max) {
        max = tracker[i];
        lastIndex = i;
      }
    }

    LinkedList<Integer> longestLIS = new LinkedList<>();
    longestLIS.add(nums[lastIndex]);

    while (longestLIS.size() != max) {
      longestLIS.add(nums[indexTracker[lastIndex]]);
      lastIndex = indexTracker[lastIndex];
    }

    Collections.reverse(longestLIS);
    System.out.println(longestLIS);
  }

  public static void main(String[] args) {
    printLengthOfLongestIncreasingSubsequence(new int[]{ 5, 4, 11, 1, 16, 8, 20});
  }

  public int lengthOfLIS(int[] nums) {
    int[][] dp = new int[nums.length ][nums.length + 1];
    for(int [] value : dp) {
      Arrays.fill(value, -1);
    }
    return lengthOfLiS(0, -1, nums, dp);
  }
}
