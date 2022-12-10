package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_523 {

  public static boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    indexMap.put(0, -1);
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int remainder = sum % k;
      if (indexMap.containsKey(remainder)) {
        if (Math.abs(i - indexMap.get(remainder)) >= 2) {
          return true;
        }
      } else {
        indexMap.put(remainder, i);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
  }

}
