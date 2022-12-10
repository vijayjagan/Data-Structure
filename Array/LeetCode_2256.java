package Array;

import java.net.Inet4Address;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;

public class LeetCode_2256 {

  public static int minimumAverageDifference(int[] nums) {
    long total = 0;

    for (int val : nums) {
      total += val;
    }

    int index = 0;
    long globalMin = Long.MAX_VALUE;

    long runTimeTotal = 0;
    for (int i = 0; i < nums.length; i++) {
      runTimeTotal += nums[i];
      long left = runTimeTotal / (i + 1);
      long rightCount = nums.length - (i + 1);
      long curr;
      if (rightCount == 0) {
        curr = left;
      } else {
        long right = (total - runTimeTotal) / rightCount;
        curr = Math.abs(left - right);
      }
      if (curr < globalMin) {
        globalMin = curr;
        index = i;
      }
    }
    return index;
  }

  public static void main(String[] args) {
    int[] nums = {2, 5, 3, 9, 5, 3};
    System.out.println(minimumAverageDifference(nums));
  }

}
